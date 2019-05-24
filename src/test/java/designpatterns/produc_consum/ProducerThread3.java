package designpatterns.produc_consum;

/**
 * 生产者线程
 * @author tangzhijing
 *
 */
public class ProducerThread3 extends Thread {
    private Resource3 resource3;
    public ProducerThread3(Resource3 resource) {
        this.resource3 = resource;
        //setName("生产者");
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (2000 * Math.random()+1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource3.add();
        }
    }
}
