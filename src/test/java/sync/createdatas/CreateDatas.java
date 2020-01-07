package sync.createdatas;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.*;

public class CreateDatas {


    @Test
    public void TestInsertDatas(){
        //生成一百万条数据
        int n = 1000000;
        List<Map<String, Object>> dataMapList = getDemoList(n);
        //System.out.println(dataMapList);
        Long startTime = System.currentTimeMillis();
        Connection conn = null;
        try {
            conn = getTestDbConn();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            insertDatasByNum(conn, dataMapList);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\n---> 插入数据出错");
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("插入 <"+n+"> 条数据 共耗时 : "+((endTime-startTime)/1000)+"秒");
    }

    private void insertDatasByNum(Connection conn, List<Map<String, Object>> dataMapList) throws SQLException {
        String insertEmpSql =   " insert into employee (`name`, age, gender, hiredate, salary) " +
                                " values (?, ?, ?, ?, ?) ";
        String insertBasicInfoSql = "insert into basic_info (emp_id, height, weight, phone) values (?, ?, ?, ?) ";
        String insertEmpScoreSql = "insert into emp_score (emp_id, yuwen, shuxue, waiyu) values (?, ?, ?, ?) ";
        String s = null;

        try {
            conn.setAutoCommit(false);

            PreparedStatement insertEmpPs = conn.prepareStatement(insertEmpSql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement insertBasicInfoPs = conn.prepareStatement(insertBasicInfoSql);
            PreparedStatement insertEmpScorePs = conn.prepareStatement(insertEmpScoreSql);

            for(Map<String, Object> dataMap:dataMapList){
                //System.out.println("---> 要插入的数据为 : "+dataMap);
                insertEmpPs.setObject(1, dataMap.get("NAME"));
                insertEmpPs.setObject(2, dataMap.get("AGE"));
                insertEmpPs.setObject(3, dataMap.get("GENDER"));
                insertEmpPs.setObject(4, dataMap.get("HIREDATE"));
                insertEmpPs.setObject(5, dataMap.get("SALARY"));
                int row = insertEmpPs.executeUpdate();
                if(row>0){
                    ResultSet rs = insertEmpPs.getGeneratedKeys();
                    if(rs.next()){
                        Long id = rs.getLong(1);
                        //System.out.println("->ID : "+id);
                        insertBasicInfoPs.setObject(1, id);
                        insertBasicInfoPs.setObject(2, dataMap.get("HEIGHT"));
                        insertBasicInfoPs.setObject(3, dataMap.get("WEIGHT"));
                        insertBasicInfoPs.setObject(4, dataMap.get("PHONE"));
                        insertBasicInfoPs.executeUpdate();

                        insertEmpScorePs.setObject(1, id);
                        insertEmpScorePs.setObject(2, dataMap.get("YUWEN"));
                        insertEmpScorePs.setObject(3, dataMap.get("SHUXUE"));
                        insertEmpScorePs.setObject(4, dataMap.get("WAIYU"));
                        insertEmpScorePs.executeUpdate();
                    }
                }
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }

    }

    /**
     * 获取测试库的链接
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private Connection getTestDbConn() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "7241";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    /**
     * 生成一百万条数据数据格式为Map
     *
     * @return
     */
    private List<Map<String, Object>> getDemoList(int n) {
        List<Map<String, Object>> mapList = new LinkedList<>();
        Date now = new Date();
        for(int i=0; i<n; i++){
            Map<String, Object> dataMap = new HashMap<>();
            //生成姓名
            dataMap.put("NAME", RandomStringUtils.randomAlphabetic(10));
            dataMap.put("AGE", RandomUtils.nextInt(18, 95));
            dataMap.put("GENDER", RandomUtils.nextInt(0, 2));
            dataMap.put("HIREDATE", new Date());
            dataMap.put("SALARY", new BigDecimal(RandomUtils.nextDouble(4500, 10000)).setScale(2, BigDecimal.ROUND_UP).doubleValue());

            dataMap.put("HEIGHT", RandomUtils.nextInt(160, 221));
            dataMap.put("WEIGHT", new BigDecimal(RandomUtils.nextDouble(50, 300)).setScale(2, BigDecimal.ROUND_UP).doubleValue());
            dataMap.put("PHONE", "1"+ RandomUtils.nextInt(3, 10)+RandomStringUtils.randomNumeric(9));

            dataMap.put("YUWEN", RandomUtils.nextInt(10, 101));
            dataMap.put("SHUXUE", RandomUtils.nextInt(10, 101));
            dataMap.put("WAIYU", RandomUtils.nextInt(10, 101));
            mapList.add(dataMap);
        }
        return mapList;
    }

    /**
     * 测试一些随机函数
     */
    @Test
    public void testRandomFunc(){
        for(int i=0; i<10; i++){
            //System.out.println(RandomUtils.nextInt(18, 95));
            //System.out.println(RandomUtils.nextInt(0, 2));
            //System.out.println(new BigDecimal(RandomUtils.nextDouble(4500, 10000)).setScale(2, BigDecimal.ROUND_UP).doubleValue());
            //System.out.println(new BigDecimal(RandomUtils.nextDouble(50, 300)).setScale(2, BigDecimal.ROUND_UP).doubleValue());
            System.out.println("1"+ RandomUtils.nextInt(3, 10)+RandomStringUtils.randomNumeric(9));
        }
    }
}
