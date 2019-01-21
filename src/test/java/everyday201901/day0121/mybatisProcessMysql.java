package everyday201901.day0121;

import com.wangbodang.demo.entity.Employee;
import com.wangbodang.demo.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class mybatisProcessMysql {

    @Test
    public void insertManyRecords(){
        String resource = "mybatis-conf/mybatis-conf.xml";
        try {
            /*InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //使用Oracle数据源
            System.out.println("---->使用Oracle数据源");
            SqlSession sqlSession = sqlSessionFactory.openSession();
            ZzjgMapper zzjgMapper = sqlSession.getMapper(ZzjgMapper.class);
            List<ZzjgEntity> list = zzjgMapper.findAll();
            int rows = 0;
            for(ZzjgEntity zzjg:list) {
                System.out.println(zzjg);
                rows++;
                if(rows>5) {
                    break;
                }
            }*/

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
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
