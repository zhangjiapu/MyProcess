package producerconsumer.waylock;

import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {

    private String name;
    private ReentrantLock lock;
    private Container bowl;

    public Consumer(String name, ReentrantLock lock,Container bowl){
        this.name = name;
        this.lock = lock;
        this.bowl = bowl;
    }

    @Override
    public void run() {
        while(true){
            try{
                bowl.consumeStuff(lock,name);
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
