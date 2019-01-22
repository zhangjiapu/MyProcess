package producerconsumer.waysynchonized;

import producerconsumer.waylock.Worker;

public class Woker implements Runnable {

    private Bowl bowl;

    public Woker(Bowl bowl){
        this.bowl = bowl;
    }

    @Override
    public void run() {
        while (true){
            synchronized (this){
                try {
                    this.bowl.setApple(bowl.getApple()+1);
                    System.out.println("Worker :"+ Thread.currentThread().getName()+"\tApple in Bowl :"+this.bowl.getApple());
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
