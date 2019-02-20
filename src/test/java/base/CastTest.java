package base;

import base.entity.A;
import base.entity.B;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * java中的cast方法
 *
 * https://www.cnblogs.com/tuhooo/p/7544743.html
 */

public class CastTest {

    @Test
    public void testCast(){
        CastTest cls = new CastTest();
        Class c = cls.getClass();
        System.out.println(c);
        System.out.println(c.getName());

        System.out.println(StringUtils.repeat("=", 40));

        Object obj = new A();
        B b1 = new B();
        b1.show();

        System.out.println(StringUtils.center("=", 40, "="));
        // casts object
        A a = new A();
        System.out.println(a.getClass());     // 1. 打印a的class对象
        a = A.class.cast(b1);
        a.show();


        System.out.println(StringUtils.center("=", 40, "="));
        System.out.println(obj.getClass());
        System.out.println(b1.getClass());
        System.out.println(a.getClass());      // 2. 打印a转换后的class对象

    }
}
