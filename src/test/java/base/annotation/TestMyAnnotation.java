package base.annotation;

import common.annotation.BlankAnno;
import common.annotation.MyAnnotation;
import org.junit.Test;

public class TestMyAnnotation {

    /**
     * 测试注解
     */
    @Test
    public void testMyAnno(){
        Class<MyTestClass> clazz = MyTestClass.class;

        if(clazz.isAnnotationPresent(MyAnnotation.class)){
            System.out.println("---> 使用了MyAnnotation注解");
        }else{
            System.out.println("---> 没有MyAnnotation注解");
        }
    }
}
