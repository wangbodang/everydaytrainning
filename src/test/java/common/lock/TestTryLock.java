package common.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestTryLock {
    private List<Integer> arrayList = new ArrayList<>();
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        TestTryLock testTryLock = new TestTryLock();
        new Thread(){
            @Override
            public void run() {
                testTryLock.insert(Thread.currentThread());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                testTryLock.insert(Thread.currentThread());
            }
        }.start();

    }

    public void insert(Thread thread) {
        if(lock.tryLock()) {
            try {
                System.out.println(thread.getName()+"得到了锁");
                for(int i=0;i<5;i++) {
                    arrayList.add(i);
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                System.out.println(thread.getName()+"释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName()+"获取锁失败");
        }
    }
}
