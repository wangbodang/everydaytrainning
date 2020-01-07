package base.threadlocal;

public class MainEntrance {

    public static void main(String[] args) throws InterruptedException {

        MyThreadLocalUtil my = new MyThreadLocalUtil();
        my.setTLValue();
        my.printValue();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                my.setTLValue();
                my.printValue();
            }
        };
        Thread t = new Thread(r, "fook");
        t.start();
        t.join();

    }
}
