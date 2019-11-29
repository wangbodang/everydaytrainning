package everyday.month201911.day1129;

import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 这个demo是测试Connection在连续事务中，如果有一个抛异常， 其他是否提交
 */
public class TestConnection {

    @Test
    public void testConn() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "7241";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);

        conn.setAutoCommit(false);

        for(int i=0;i<10;i++){
            insertAEmp(i, "wangbodang"+i, conn);
        }

        conn.close();
    }

    private void insertAEmp(int i, String name, Connection conn) {

        String insertSql = "insert into employee (name, age, salary) values (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(insertSql);
            ps.setString(1, name);
            ps.setInt(2, i*10);
            ps.setBigDecimal(3, new BigDecimal(i*1000.1));
            if(i==7){
                "111".charAt(333);
            }
            ps.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (Exception e){
            System.out.println("执行出现异常 : "+e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
