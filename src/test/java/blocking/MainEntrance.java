package blocking;

import blocking.task.ConsumerTask;
import blocking.task.MonitorTask;
import blocking.task.ProducerTask;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者消费者主入口
 */
public class MainEntrance {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 用缓冲队列处理生产者&消费者
     */
    @Test
    public void testBlockingQueue(){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(4);
        ThreadPoolTaskExecutor poolTaskExecutor = getPool();

        poolTaskExecutor.execute(new MonitorTask(blockingQueue));
        poolTaskExecutor.execute(new ProducerTask(blockingQueue));

        poolTaskExecutor.execute(new ConsumerTask(blockingQueue));
        poolTaskExecutor.execute(new ConsumerTask(blockingQueue));

        while (true);
    }

    private ThreadPoolTaskExecutor getPool() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(4);
        threadPoolTaskExecutor.setMaxPoolSize(7);
        threadPoolTaskExecutor.setQueueCapacity(300);
        threadPoolTaskExecutor.setQueueCapacity(300);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;

    }
}
