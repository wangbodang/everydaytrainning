package base.threadlocal;

import java.util.Random;

public class MyThreadLocalUtil {

    ThreadLocal<Integer> tlInt = new ThreadLocal<>();
    ThreadLocal<String> tlString = new ThreadLocal<>();

    public void setTLValue(){
        Random r = new Random();
        tlInt.set(r.nextInt(1000));
        tlString.set("当前线程名称 : "+Thread.currentThread().getName());
    }

    public void printValue(){
        System.out.println("--->"+tlInt.get());
        System.out.println("--->"+tlString.get());
    }
}
