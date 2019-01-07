package producerconsumer.methodsemaphore;

public class MyProducer implements Runnable {

    private String name;
    private MyRepository repository;
    private Boolean isStop;

    public MyProducer(String name,MyRepository repository,Boolean isStop){
        this.name = name;
        this.repository = repository;
        this.isStop = isStop;
    }

    public MyProducer(String name,MyRepository repository){
        this.name = name;
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true){
            try {
                repository.add(1,this.name);
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

}
