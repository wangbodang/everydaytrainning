package base.threadlocal;

import common.util.MyThreadUtil;

public class MiloTheadLocal {

    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final MiloTheadLocal test = new MiloTheadLocal();

        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());


        Thread thread=new Thread() {
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            }
        };

        thread.start();
        //thread.join():用来指定当前主线程等待其他线程执行完毕后,再来继续执行Thread.join()后面的代码
        thread.join();
        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread2=new Thread() {
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            }
        };
        thread2.start();
        //thread.join():用来指定当前主线程等待其他线程执行完毕后,再来继续执行Thread.join()后面的代码
        thread2.join();
        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
