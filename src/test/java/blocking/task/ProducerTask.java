package blocking.task;

import cn.hutool.core.util.RandomUtil;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

public class ProducerTask implements Runnable{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private BlockingQueue blockingQueue;
    public ProducerTask(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){

            int i = RandomUtil.randomInt(1, 1000);
            logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>>>>> 随机产生数为:{}", i);
            try {
                blockingQueue.put(String.valueOf(i));
                logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++>>>>> {} 加入队列 ", i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(RandomUtil.randomInt(1500, 3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
