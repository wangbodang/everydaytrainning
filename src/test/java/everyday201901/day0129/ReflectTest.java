package everyday201901.day0129;

import com.wangbodang.demo.entity.Employee;
import demo.Base;
import demo.Derived;
import demo.XYZ;
import org.junit.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Reflect
 */
public class ReflectTest {


    @Test
    public void test01(){
        System.out.println(XYZ.name);
    }

    @Test
    public void test02(){
        // 不会初始化静态块
        Class clazz1 = Base.class;
        System.out.println("------");

        // 会初始化
        try {
            Class clazz2 = Class.forName("demo.Base");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03(){
        Base base = new Derived();
        if(base instanceof Base){
            System.out.println("True");
        }
    }

    @Test
    public void test04() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Employee emp = new Employee();
        emp.setName("wangbodang");

        Class clazz = emp.getClass();
        System.out.println("--->类名:"+clazz.getName());
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
            Method method = descriptor.getReadMethod();
            Object value = method.invoke(emp);

            System.out.println(key + ":" + value);
        }
    }

    @Test
    public void test05(){
        RealObject real = new RealObject();
        MyInterface myInterface = (MyInterface)Proxy.newProxyInstance(MyInterface.class.getClassLoader(), new Class[]{MyInterface.class}, new MyDynamicProxyHandler(real));

        myInterface.doSomething();
        myInterface.somethingElse("wangbodang");

    }
}
