package everyday201901.day0121;

import com.wangbodang.demo.entity.Employee;
import com.wangbodang.demo.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class mybatisProcessMysql {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    @Before
    public void init(){
        String resource = "mybatis-conf/mybatis-conf.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "dev_mysql");
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void destory(){
        sqlSession.close();
    }

    /***
     * 测试下
     */
    @Test
    public void insertManyRecords(){
        String resource = "mybatis-conf/mybatis-conf.xml";
        try {

            //使用Mysql数据源
            System.out.println("\n\n\n--->使用Mysql数据源");
            //再获得一遍
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory mysql_sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "dev_mysql");
            SqlSession mysql_SqlSession = mysql_sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = mysql_SqlSession.getMapper(EmployeeMapper.class);
            Employee emp = employeeMapper.selectByPrimaryKey(11001);
            System.out.println("  => emp:"+emp);
            Employee insertEmp = new Employee();
            insertEmp.setName("孙承宗");
            insertEmp.setAge(39);
            int insertRows = employeeMapper.insertSelective(insertEmp);
            if(insertRows<1) {
                System.out.println(" ==> 没有插入数据");
            }else {
                System.out.println(" ==> 插入一条数据  其id为:"+insertEmp.getId());
            }
            mysql_SqlSession.commit();
            mysql_SqlSession.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 测试下插入数万条记录需要的时间
     */
    @Test
    public void insertOneMillionRecords(){
        String resource = "mybatis-conf/mybatis-conf.xml";
        try {

            System.out.println("\n\n\n--->使用Mysql数据源");
            //再获得一遍
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory mysql_sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "dev_mysql");

            SqlSession mysql_SqlSession = mysql_sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = mysql_SqlSession.getMapper(EmployeeMapper.class);

            int counts = 30000;

            long startTime = System.currentTimeMillis();
            for(int i=0;i<counts;i++){
                Employee insertEmp = new Employee();
                insertEmp.setName("孙承宗");
                insertEmp.setAge(39);
                int insertRows = employeeMapper.insertSelective(insertEmp);
                //mysql_SqlSession.commit();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("---> 插入"+counts+"条记录, 共用时:"+(endTime-startTime)/1000+"秒");
            mysql_SqlSession.commit();
            mysql_SqlSession.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //测试下数据库删除记录需要的时间
    //删除超加大于11021的记录
    @Test
    public void delManyRecords(){
        String resource = "mybatis-conf/mybatis-conf.xml";
        try {

            System.out.println("\n\n\n--->使用Mysql数据源");
            //再获得一遍
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory mysql_sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "dev_mysql");

            SqlSession mysql_SqlSession = mysql_sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = mysql_SqlSession.getMapper(EmployeeMapper.class);

            long startTime = System.currentTimeMillis();

            int maxId = employeeMapper.findMaxId();
            int counts = 0;
            while(maxId>11021){
                int rows = employeeMapper.deleteByPrimaryKey(maxId);
                counts++;
                maxId = employeeMapper.findMaxId();
            }
            mysql_SqlSession.commit();

            long endTime = System.currentTimeMillis();
            System.out.println("---> 插入"+counts+"条记录, 共用时:"+(endTime-startTime)/1000+"秒");
            mysql_SqlSession.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //测试 批量插入 更新的语名
    @Test
    public void testBatchInsert(){
        String resource = "mybatis-conf/mybatis-conf.xml";
        try {

            System.out.println("\n\n\n--->使用Mysql数据源");
            //再获得一遍
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory mysql_sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "dev_mysql");

            SqlSession mysql_SqlSession = mysql_sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = mysql_SqlSession.getMapper(EmployeeMapper.class);

            List<Employee> empList = new ArrayList<>();
            for(int i=0;i<5;i++){
                Employee emp1 = new Employee();
                emp1.setName("John"+i);
                emp1.setAge(33+i);
                emp1.setRemark("St.John"+i);
                empList.add(emp1);
            }
            int rows = employeeMapper.batchInsertEmp(empList);
            System.out.println("\n===>插入的记录数为:"+rows);
            for(Employee emp:empList){
                System.out.println("->"+emp.getId());
            }
            mysql_SqlSession.commit();
            mysql_SqlSession.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //批量更新
    @Test
    public void testBatchUpdate(){
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> empList = new ArrayList<>();
        for(int i=11005;i<11022;i++){
            Employee emp = employeeMapper.selectByPrimaryKey(i);
            if(emp!=null){
                empList.add(emp);
            }
        }
        //批量更新

        System.out.println("--->查询的个数:"+empList.size());
    }
}
