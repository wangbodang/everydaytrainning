package sync.createuser;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class TaskForWritToSample implements Runnable {
    private List<Map<String, Object>> empList;
    private CountDownLatch countDownLatch;
    private DataSource dataSource;

    public TaskForWritToSample(List<Map<String, Object>> empList,
                               CountDownLatch countDownLatch,
                               DataSource dataSourceSample){
        this.empList = empList;
        this.countDownLatch = countDownLatch;
        this.dataSource = dataSourceSample;
    }


    // SbJtumjjmX  如果名字为此抛出异常
    @Override
    public void run() {
        String insertSql = "insert into user (`emp_id`, `name`) values (?, ?) ";

        try {
            Connection connSample = dataSource.getConnection();
            connSample.setAutoCommit(false);
            PreparedStatement insertPs = connSample.prepareStatement(insertSql);
            for(Map<String, Object> empMap:empList){
                insertPs.setObject(1, empMap.get("ID"));
                /*if("SbJtumjjmX".equalsIgnoreCase(empMap.get("NAME").toString().trim())){
                    "a".charAt(333);
                }*/
                insertPs.setObject(2, empMap.get("NAME"));
                insertPs.addBatch();
            }
            insertPs.executeBatch();
            connSample.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\n===> 线程内部SQL写入出错... 线程 : "+Thread.currentThread().getId()+", "+Thread.currentThread().getName());
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("\n===> 线程内部写入出错... 线程 : "+Thread.currentThread().getId()+", "+Thread.currentThread().getName()+", 消息 : "+e.getMessage());
        }
        countDownLatch.countDown();
    }


}
