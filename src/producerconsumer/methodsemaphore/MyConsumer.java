package producerconsumer.methodsemaphore;

public class MyConsumer implements Runnable {

    private String name;
    private MyRepository repository;

    public MyConsumer(String name,MyRepository repository){
        this.name = name;
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true) {
            try {
                repository.remove(1,this.name);
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
