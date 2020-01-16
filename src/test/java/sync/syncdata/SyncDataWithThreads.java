package sync.syncdata;

import common.tools.TestDbTool;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class SyncDataWithThreads {

    @Test
    public void syncDataWithMultiThreads(){

        //先查询出来sample中的所有user 返回list
        Long startTime = System.currentTimeMillis();
        List<Map<String, Object>> userMapList = getUserMapList();
        Long endTime = System.currentTimeMillis();
        System.out.println("---> 查询共用时 : " + ((endTime - startTime) / 1000) + " 秒");
        System.out.println("\n===> 查询出user数量为 : "+userMapList.size());

        startTime = System.currentTimeMillis();

        DataSource testDataSource = TestDbTool.getTestDataSource();
        DataSource sampleDataSource = TestDbTool.getSampleDataSource();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            TaskForSyncDataToSample taskForSync = new TaskForSyncDataToSample(userMapList, countDownLatch, testDataSource.getConnection(), sampleDataSource.getConnection());
            Thread t = new Thread(taskForSync);
            t.start();
            t.join();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        endTime = System.currentTimeMillis();
        System.out.println("---> 同步共用时 : " + ((endTime - startTime) / 1000) + " 秒");
    }


    private List<Map<String, Object>> getUserMapList() {
        Connection sampleConn = TestDbTool.getSampleConn();
        String queryUserSql = "SELECT `id`, `emp_id`, `name` FROM sample.`user` where id<10000";
        List<Map<String, Object>> resultList = new ArrayList<>();
        try {
            PreparedStatement queryUserPs = sampleConn.prepareStatement(queryUserSql);
            ResultSet userRs = queryUserPs.executeQuery();
            while (userRs.next()){
                Map<String, Object> tempMap = new HashMap<>();
                Long userId = userRs.getLong("ID");
                Long emp_id = userRs.getLong("EMP_ID");
                String name = userRs.getString("NAME");

                tempMap.put("ID", userId);
                tempMap.put("EMP_ID", emp_id);
                tempMap.put("NAME", name);

                resultList.add(tempMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }
}
