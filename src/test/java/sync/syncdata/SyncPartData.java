package sync.syncdata;

import common.tools.TestDbTool;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.sql.*;

/**
 * 同步部分数据
 */
public class SyncPartData {

    @Test
    public void syncData(){
        Connection testConn = TestDbTool.getTestConn();
        System.out.println(testConn);
        Connection sampleConn = TestDbTool.getSampleConn();
        System.out.println(sampleConn);

        String queryUserSql = "SELECT `id`, `emp_id`, `name` FROM sample.`user` where id<70";
        String queryEmpInfoSql = "SELECT e.`Id` AS emp_id, e.`Name` AS emp_name, e.`Age`, e.`Hiredate`, e.`Gender`, e.`Salary` " +
                                    " FROM employee e " +
                                    " WHERE e.`ID` = ? ";

        String updateUserInfoSql = "update user set age = ?, gender = ?, hiredate = ?, salary = ? " +
                                    " where emp_id = ? ";
        Long startTime = System.currentTimeMillis();
        try {
            testConn.setAutoCommit(false);
            sampleConn.setAutoCommit(false);

            PreparedStatement queryUserPs = sampleConn.prepareStatement(queryUserSql);
            ResultSet userRs = queryUserPs.executeQuery();

            int i=0;
            while (userRs.next()){
                i++;
                Long userId = userRs.getLong("ID");
                Long emp_id = userRs.getLong("EMP_ID");
                String name = userRs.getString("NAME");

                if(30 == i){
                    System.out.println("---> "+userId+", "+emp_id+", "+name);
                }
                PreparedStatement queryEmpInfoPs = testConn.prepareStatement(queryEmpInfoSql);
                queryEmpInfoPs.setLong(1, emp_id);

                ResultSet empInfoRs = queryEmpInfoPs.executeQuery();
                while (empInfoRs.next()){
                    Integer age = empInfoRs.getInt("AGE");
                    Date hiredate = empInfoRs.getDate("HIREDATE");
                    Integer gender = empInfoRs.getInt("GENDER");
                    BigDecimal salary = empInfoRs.getBigDecimal("SALARY");

                    if(30 == i){
                        System.out.println("---> "+hiredate+", "+salary);
                    }

                    PreparedStatement updateUserInfoPs = sampleConn.prepareStatement(updateUserInfoSql);
                 /*    "update user set age = ?, gender = ?, hiredate = ?, salary = ?," +
                            " yuwen = ?, shuxue = ?, waiyu = ?, height = ?, weight = ?, phone = ? " +
                            " where emp_id = ? ";*/
                    updateUserInfoPs.setObject(1, age);
                    updateUserInfoPs.setObject(2, gender);
                    updateUserInfoPs.setObject(3, hiredate);
                    updateUserInfoPs.setObject(4, salary);

                    updateUserInfoPs.setObject(5, emp_id);

                    updateUserInfoPs.executeUpdate();
                }


            }
            System.out.println("共有人数 : "+i);


            //查询出来数据
            sampleConn.commit();

            Long endTime = System.currentTimeMillis();
            System.out.println("---> 同步共用时 : " + ((endTime - startTime) / 1000) + " 秒");
            File destFile = new File("D:"+File.separator+"TEST"+File.separator+"result.txt");
            OutputStream os = new FileOutputStream(destFile);
            OutputStreamWriter osw = new OutputStreamWriter(os, Charset.forName("UTF-8"));
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write("---> 同步共用时 : " + ((endTime - startTime) / 1000) + " 秒");
            bw.flush();
            bw.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            TestDbTool.closeConn(testConn);
            TestDbTool.closeConn(sampleConn);
        }

    }
}
