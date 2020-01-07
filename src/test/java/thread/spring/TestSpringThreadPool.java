package thread.spring;

import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 测试spring线程池
 */
public class TestSpringThreadPool {

    @Test
    public void testSpringPool(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.initialize();

        System.out.println(executor.getThreadNamePrefix());
        System.out.println(executor.getActiveCount());
        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getKeepAliveSeconds());
        System.out.println(executor.getMaxPoolSize());
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getThreadPoolExecutor());

        System.out.println("xxxxxxxxxxxxx");
        executor.setCorePoolSize(11333);
        executor.setKeepAliveSeconds(300);
        executor.setMaxPoolSize(33333);
        System.out.println(executor.getMaxPoolSize());

    }
}
