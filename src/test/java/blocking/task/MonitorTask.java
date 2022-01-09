package blocking.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

public class MonitorTask implements Runnable{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private BlockingQueue blockingQueue;

    public MonitorTask(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        while(true){
            logger.info("---> blockingQueue.size()={}", blockingQueue.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
