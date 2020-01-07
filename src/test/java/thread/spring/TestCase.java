package thread.spring;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TestCase {

    private static ThreadPoolTaskExecutor threadPoolTest = new ThreadPoolTaskExecutor();

    public static void main(String[] args) {
        threadPoolTest.initialize();
        List<List<Integer>> idList = new ArrayList<List<Integer>>();
        idList.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        idList.add(new ArrayList<Integer>(Arrays.asList(4, 5)));
        // 创建一个初始值为2的倒数计数器
        CountDownLatch countDownLatch = new CountDownLatch(idList.size());

        System.out.println("自动扣款多线开启" + new Date());
        for (List<Integer> idListSub : idList) {
            if (CollectionUtils.isEmpty(idListSub)) continue;
            TreadCase thread = new TreadCase(idListSub, countDownLatch);
            threadPoolTest.execute(thread);
        }

        // 阻塞当前线程，直到倒数计数器倒数到0
        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("自动扣款多线程结束" + new Date());
        // threadPool.destroy();

    }
}
