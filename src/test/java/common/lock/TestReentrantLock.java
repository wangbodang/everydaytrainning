package common.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

    private ArrayList<Integer> arrayList = new ArrayList<Integer>();


    public static void main(String[] args) throws InterruptedException {
        System.out.println("yyy");
        final TestReentrantLock test = new TestReentrantLock();

        Thread t1= new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            }
        };

        t2.start();
        t1.join();
        t2.join();
        System.out.println(test.arrayList);
    }


    public void insert(Thread thread) {
        Lock lock = new ReentrantLock();    //注意这个地方
        lock.lock();
        try {
            System.out.println(thread.getName() + "得到了锁");
            for (int i = 0; i < 5; i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.println(thread.getName() + "释放了锁");
            lock.unlock();
        }
    }
}
