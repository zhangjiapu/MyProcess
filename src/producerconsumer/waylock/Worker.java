package producerconsumer.waylock;

import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable{
    private String name;
    private ReentrantLock lock;
    private Container bowl;

    public Worker(String name,ReentrantLock lock,Container bowl) {
        this.name = name;
        this.lock = lock;
        this.bowl = bowl;
    }

    @Override
    public void run() {
        while (true){
            try{
                bowl.makeStuff(lock,name);
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
