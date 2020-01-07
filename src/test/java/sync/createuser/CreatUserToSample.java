package sync.createuser;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.poi.ss.formula.functions.T;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

public class CreatUserToSample {
    private static Connection connTest;
    private static Connection connSample;
    private static DataSource dataSourceSample;

    @Before
    public void init() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=UTC";
        String urlS = "jdbc:mysql://127.0.0.1:3306/sample?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "7241";
        connTest = DriverManager.getConnection(url, username, password);
        connSample = DriverManager.getConnection(urlS, username, password);

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(urlS);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(150);                    //设置最大连接数
        dataSource.setInitialSize(10);                  //设置初始化连接数
        dataSource.setMaxIdle(8);                       //当空闲下载的时候，连接最大数量
        dataSource.setMinIdle(5);                       //当空闲时间过长后，变为最小空闲
        dataSourceSample = dataSource;
    }

    /**
     * 把人员名字同步到另一个库中
     */
    @Test
    public void testSync(){

        try {
            connSample.setAutoCommit(false);
            connTest.setAutoCommit(false);

            //查出所有的人员信息
            Long startTime = System.currentTimeMillis();
            List<Map<String, Object>> empList = getEmpList(10000000);
            System.out.println("\n----> 查出来的长度为 : "+empList.size());
            Long endTime = System.currentTimeMillis();
            System.out.println("---> 查询共用时 : " + ((endTime - startTime) / 1000) + " 秒");

            //写入另一个库
            startTime = System.currentTimeMillis();

            //直接写入
            //writeToSample(empList, connSample);

            //分批写入
            writeToSampleByGroup(empList, connSample, dataSourceSample);

            endTime = System.currentTimeMillis();
            System.out.println("---> 写入共用时 : " + ((endTime - startTime) / 1000) + " 秒");
            connSample.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connTest.rollback();
                connSample.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("\n---> 同步异常");
            }

        } finally {
            try {
                connTest.close();
                connSample.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("\n---> 关闭异常");
            }
        }

    }



    /**
     * 写入另一个库
     *  普通方法， 共计大约200秒
     * @param empList
     * @param connSample
     */
    private void writeToSample(List<Map<String, Object>> empList, Connection connSample) throws SQLException {
        String insertSql = "insert into user (`emp_id`, `name`) values (?, ?) ";
        PreparedStatement insertPs = connSample.prepareStatement(insertSql);
        for(Map<String, Object> empMap:empList){
            insertPs.setObject(1, empMap.get("ID"));
            insertPs.setObject(2, empMap.get("NAME"));
            insertPs.executeUpdate();
        }
        connSample.commit();
    }

    /**
     * 分组把数据写入
     * @param empList
     * @param connSample
     */
    private void writeToSampleByGroup(List<Map<String, Object>> empList, Connection connSample, DataSource dataSourceSample) throws SQLException {
        int step = 10000; //分组的步长为 10000
        int count = empList.size()/step + ((empList.size()%step==0)?0:1);
        System.out.println("步长 : "+step+", 共分为 : "+count+" 段");

        //加入计时器
        CountDownLatch countDownLatch = new CountDownLatch(count);

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);//核心线程大小
        executor.setMaxPoolSize(150);//最大线程大小
        executor.setQueueCapacity(200);//队列最大容量
        executor.setKeepAliveSeconds(3000);//存活时间
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//拒绝执行时如何处理
        executor.initialize();

        for(int i=0;i<count;i++){
            List<Map<String, Object>> subList = null;
            if(i<count-1){
                subList = empList.subList(i * step, (i + 1) * step);
            }else{
                subList = empList.subList(i * step, empList.size());
            }

            //System.out.println("第 "+i+" 个 子列的长度 : "+subList.size());
            //普通写入
            //writeToSampleBySubList(subList, connSample);
            //开线程写入
            TaskForWritToSample task = new TaskForWritToSample(subList, countDownLatch, dataSourceSample);
            executor.execute(task);
        }
        // 阻塞当前线程，直到倒数计数器倒数到0
        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入一万个，分批
     * @param subList
     * @param connSample
     */
    private void writeToSampleBySubList(List<Map<String, Object>> subList, Connection connSample) throws SQLException {
        String insertSql = "insert into user (`emp_id`, `name`) values (?, ?) ";
        try {
            PreparedStatement insertPs = connSample.prepareStatement(insertSql);
            for(Map<String, Object> empMap:subList){
                insertPs.setObject(1, empMap.get("ID"));
                insertPs.setObject(2, empMap.get("NAME"));
                insertPs.addBatch();
            }
            insertPs.executeBatch();
            connSample.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * 从test库里找到所有的员工表
     * @return
     */
    private List<Map<String, Object>> getEmpList(int sum) throws SQLException {
        List<Map<String, Object>> empList = new ArrayList<>();
        String querySql = "select * from employee";
        Statement smt = connTest.createStatement();
        ResultSet rs = smt.executeQuery(querySql);
        int i = 1;
        while (rs.next()){
            if(i>sum){
                break;
            }
            Map<String, Object> empMap = new HashMap<>();
            empMap.put("ID", rs.getLong("ID"));
            empMap.put("NAME", rs.getString("NAME"));
            empList.add(empMap);
            //System.out.println("-> 人员基本信息 : "+empMap);
            i++;
        }
        return empList;
    }

    @After
    public void destory(){
        try {
            connTest.close();
            connTest.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
