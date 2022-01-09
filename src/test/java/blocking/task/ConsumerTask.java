package blocking.task;

import cn.hutool.core.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

public class ConsumerTask implements Runnable{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private BlockingQueue<String> blockingQueue;
    public ConsumerTask(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        Thread curThread = Thread.currentThread();
        while(true){
            logger.info("-----====== 线程:{}-{} 从队列中取数", curThread.getId(), curThread.getName());
            try {
                String take = blockingQueue.take();
                logger.info("-----============== 线程:{}-{} 从队列中取出数为:{}", curThread.getId(), curThread.getName(), take);

                Thread.sleep(RandomUtil.randomInt(1000, 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
