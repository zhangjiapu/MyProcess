package producerconsumer.methodsemaphore;

public class MultiProcess {
    public static void main(String[] args) {
        MyRepository repository = new MyRepository(10);
        //生产者
        new Thread(new MyProducer("woker1",repository,true)).start();
//        new Thread(new MyProducer("woker2",repository,true)).start();

        //消费者
        new Thread(new MyConsumer("consumer1",repository)).start();
        new Thread(new MyConsumer("consumer2",repository)).start();
    }
}
