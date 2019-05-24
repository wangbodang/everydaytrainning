package designpatterns.produc_consum;

public class BlockingQueueConsumerProducer {
    public static void main(String[] args) {
        Resource3 resource = new Resource3();
        //生产者线程
        ProducerThread3 p1 = new ProducerThread3(resource);
        //p1.setName("===>>>生产者线程 1");
        ProducerThread3 p2 = new ProducerThread3(resource);
        //p2.setName("===>>>生产者线程 2");

        //多个消费者
        ConsumerThread3 c1 = new ConsumerThread3(resource);
        ConsumerThread3 c2 = new ConsumerThread3(resource);

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
