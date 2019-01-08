package producerconsumer.waylock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Container bowl = new Container();
        new Thread(new Worker("worker",lock,bowl)).start();
        new Thread(new Consumer("consumer1",lock,bowl)).start();
        new Thread(new Consumer("consumer2",lock,bowl)).start();
    }
}
