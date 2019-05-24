package designpatterns.produc_consum;

public class ConsumerThread3 extends Thread {
    private Resource3 resource3;

    public ConsumerThread3(Resource3 resource) {
        this.resource3 = resource;
        //setName("消费者");
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (2000 * Math.random()+1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource3.remove();
        }
    }
}
