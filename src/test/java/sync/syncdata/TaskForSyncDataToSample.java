package sync.syncdata;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class TaskForSyncDataToSample implements Runnable {
    private List<Map<String, Object>> userList;
    private CountDownLatch countDownLatch;
    private Connection testConn;
    private Connection sampleConn;

    public TaskForSyncDataToSample(List<Map<String, Object>> userList,
                                   CountDownLatch countDownLatch,
                                   Connection testConn,
                                   Connection sampleConn){
        this.userList = userList;
        this.countDownLatch = countDownLatch;
        this.testConn = testConn;
        this.sampleConn = sampleConn;
    }

    @Override
    public void run() {
        System.out.println("\n====> 线程同步 "+Thread.currentThread().getName());
        String queryEmpInfoSql = "SELECT e.`Id` AS emp_id, e.`Name` AS emp_name, e.`Age`, e.`Hiredate`, e.`Gender`," +
                " e.`Salary`, " +
                " es.`YUWEN`, es.`SHUXUE`, es.`WAIYU`, " +
                " bi.`WEIGHT`, bi.`HEIGHT`, bi.`PHONE` " +
                " FROM employee e, emp_score es, basic_info bi " +
                " WHERE es.`EMP_ID` = e.`Id` AND bi.`EMP_ID` = e.`Id`" +
                " and e.`ID` = ? ";
        String updateUserInfoSql = "update user set age = ?, gender = ?, hiredate = ?, salary = ?," +
                " yuwen = ?, shuxue = ?, waiyu = ?, height = ?, weight = ?, phone = ? " +
                " where emp_id = ? ";
        try {
            PreparedStatement queryEmpInfoPs = testConn.prepareStatement(queryEmpInfoSql);


            for(int i=0;i<userList.size();i++){
                Map<String, Object> userMap = userList.get(i);
                queryEmpInfoPs.setObject(1, userMap.get("EMP_ID"));

                ResultSet empInfoRs = queryEmpInfoPs.executeQuery();
                while (empInfoRs.next()){
                    Integer age = empInfoRs.getInt("AGE");
                    Date hiredate = empInfoRs.getDate("HIREDATE");
                    Integer gender = empInfoRs.getInt("GENDER");
                    BigDecimal salary = empInfoRs.getBigDecimal("SALARY");

                    Integer yuwen = empInfoRs.getInt("YUWEN");
                    Integer shuxue = empInfoRs.getInt("SHUXUE");
                    Integer waiyu = empInfoRs.getInt("WAIYU");

                    Integer height = empInfoRs.getInt("HEIGHT");
                    Double weight = empInfoRs.getDouble("WEIGHT");
                    String phone = empInfoRs.getString("PHONE");

                    PreparedStatement updateUserInfoPs = sampleConn.prepareStatement(updateUserInfoSql);
                 /*    "update user set age = ?, gender = ?, hiredate = ?, salary = ?," +
                            " yuwen = ?, shuxue = ?, waiyu = ?, height = ?, weight = ?, phone = ? " +
                            " where emp_id = ? ";*/
                    updateUserInfoPs.setObject(1, age);
                    updateUserInfoPs.setObject(2, gender);
                    updateUserInfoPs.setObject(3, hiredate);
                    updateUserInfoPs.setObject(4, salary);

                    updateUserInfoPs.setObject(5, yuwen);
                    updateUserInfoPs.setObject(6, shuxue);
                    updateUserInfoPs.setObject(7, waiyu);

                    updateUserInfoPs.setObject(8, height);
                    updateUserInfoPs.setObject(9, weight);
                    updateUserInfoPs.setObject(10, phone);

                    updateUserInfoPs.setObject(11, userMap.get("EMP_ID"));

                    updateUserInfoPs.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("同步过程中出现异常 : "+e.getMessage());
        } finally {
            countDownLatch.countDown();
        }

    }
}
