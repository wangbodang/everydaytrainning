package common.reflect;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class ReflectTest {

    @Test
    public void testReflect(){
        MyTestInterfaceImpl myTestInterface = new MyTestInterfaceImpl();

        TestInterface testInterface = (TestInterface) Proxy.newProxyInstance(TestInterface.class.getClassLoader(), new Class[]{TestInterface.class}, new MyTestDynamicProxyHandler(myTestInterface));

        testInterface.printAString();

        String s = testInterface.getAString();
        System.out.println(s);
    }
}
