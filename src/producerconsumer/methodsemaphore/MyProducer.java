package producerconsumer.methodsemaphore;

public class MyProducer implements Runnable {

    private String name;
    private MyRepository repository;
    private Boolean isStop = false;
    private int capability;

    /**
     * 生产者是否定量生产
     * @param name
     * @param repository
     * @param isStop
     */
    public MyProducer(String name,MyRepository repository,Boolean isStop){
        this.name = name;
        this.repository = repository;
        this.isStop = isStop;
        this.capability = repository.getCapability();
    }

    public MyProducer(String name,MyRepository repository){
        this.name = name;
        this.repository = repository;
    }

    @Override
    public void run() {
        if(isStop){
            while (capability > 0){
                try {
                    repository.add(1,this.name);
                    capability--;
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }else {
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

}
