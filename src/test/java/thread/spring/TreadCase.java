package thread.spring;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TreadCase implements Runnable {

    private List<Integer> returnIds;
    private CountDownLatch countDownLatch;

    public TreadCase(List<Integer> returnIds, CountDownLatch countDownLatch) {
        this.returnIds = returnIds;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        for (Integer returnId :returnIds) {
            System.out.println("富友代扣线程类启动 id="+returnId);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("富友代扣线程类关闭 ");
        }
        countDownLatch.countDown();
        System.out.println("countDownLatch="+countDownLatch.getCount());
    }

}
