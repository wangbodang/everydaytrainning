package base.thread.queue;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueReadThread {

    @Test
    public void testReadQueue(){
        Queue<Integer> intQueue = new LinkedList<>();
        Random r = new Random();

        for(int i=0; i<20; i++){
            ((LinkedList<Integer>) intQueue).push(i);
        }
        System.out.println(intQueue);
        QueueProcThread thread1 = new QueueProcThread(intQueue);
        QueueProcThread thread2 = new QueueProcThread(intQueue);
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();
        try {
           Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
