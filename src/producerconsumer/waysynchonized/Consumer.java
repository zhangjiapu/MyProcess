package producerconsumer.waysynchonized;

public class Consumer implements Runnable{

    private Bowl bowl;

    public Consumer(Bowl bowl){
        this.bowl = bowl;
    }

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(bowl.getApple() > 0){
                    try {
                        this.bowl.setApple(bowl.getApple()-1);
                        System.out.println("Consumer :"+ Thread.currentThread().getName()+"\tApple in Bowl :"+this.bowl.getApple());
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
