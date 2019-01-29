package everyday201901.day0129;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyDynamicProxyHandler implements InvocationHandler {

    private Object proxyed;

    public MyDynamicProxyHandler(Object proxyed) {
        this.proxyed = proxyed;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理工作了.");
        return method.invoke(proxyed, args);
    }
}
