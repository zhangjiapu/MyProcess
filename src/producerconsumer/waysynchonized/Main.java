package producerconsumer.waysynchonized;

public class Main {

    public static void main(String[] args) {
        Bowl bowl = new Bowl();
        Woker woker1 = new Woker(bowl);
        Woker woker2 = new Woker(bowl);
        Consumer consumer1 = new Consumer(bowl);
        Consumer consumer2 = new Consumer(bowl);

        Thread thread1 = new Thread(woker1);
        Thread thread2 = new Thread(woker2);
        Thread thread3 = new Thread(consumer1);
        Thread thread4 = new Thread(consumer2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
