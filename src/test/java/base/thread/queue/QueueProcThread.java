package base.thread.queue;

import java.util.Queue;
import java.util.Random;

public class QueueProcThread implements Runnable {

    private Queue<Integer> intQueue;

    public QueueProcThread(Queue<Integer> intQueue){
        this.intQueue = intQueue;
    }

    @Override
    public void run() {
        synchronized (intQueue){
            String result = "";
            Random r = new Random();
            int count = r.nextInt(5);
            for(int i=0;i<count;i++){
                Integer tempInt = intQueue.poll();
                if(tempInt == null){
                    break;
                }else{
                    result += tempInt+",";
                }
            }
            System.out.println(result);
        }
    }
}
