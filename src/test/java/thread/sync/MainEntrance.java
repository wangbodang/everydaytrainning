package thread.sync;

import org.junit.Test;

public class MainEntrance {
    private int t=0;
    @Test
    public void testAsync(){

        for(int i=0;i<2;i++){
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     for(int j=0;j<1000;j++){
                         addT();
                     }

                 }
             }).start();
        }
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t);
    }
    public void addT(){
        t++;
    }
}
