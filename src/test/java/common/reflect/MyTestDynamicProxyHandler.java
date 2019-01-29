package common.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyTestDynamicProxyHandler implements InvocationHandler {
    private Object proxyed;
    public MyTestDynamicProxyHandler(Object proxy){
        this.proxyed = proxy;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===>代理工作了......");
        return method.invoke(this.proxyed, args);
    }
}
