package common.tools;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 本机测试获取链接或者连接池的工具类
 */
public class TestDbTool {

    /**
     * 获取test测试库的链接
     * @return
     */
    private static BasicDataSource testBds = new BasicDataSource();
    private static BasicDataSource sampleBds = new BasicDataSource();
    static {
        InputStream fis = TestDbTool.class.getClassLoader().getResourceAsStream("testdb.properties");
        Properties dbProp = new Properties();
        try {
            dbProp.load(fis);
            testBds.setDriverClassName(dbProp.getProperty("jdbc_driver"));
            testBds.setUrl(dbProp.getProperty("jdbc_url_test"));
            testBds.setUsername(dbProp.getProperty("jdbc_username_t"));
            testBds.setPassword(dbProp.getProperty("jdbc_password_t"));
            testBds.setInitialSize(50);

            sampleBds.setDriverClassName(dbProp.getProperty("jdbc_driver"));
            sampleBds.setUrl(dbProp.getProperty("jdbc_url_sample"));
            sampleBds.setUsername(dbProp.getProperty("jdbc_username_s"));
            sampleBds.setPassword(dbProp.getProperty("jdbc_password_s"));
            sampleBds.setInitialSize(50);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getTestConn(){
        try {
            return testBds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getSampleConn(){
        try {
            return sampleBds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConn(Connection conn){
        if(conn == null){
            return;
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
