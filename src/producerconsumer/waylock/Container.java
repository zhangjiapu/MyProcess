package producerconsumer.waylock;

import java.util.concurrent.locks.ReentrantLock;

public class Container {
    private int stuff = 0;
    private ReentrantLock safeLock = new ReentrantLock();//保证消费者在消费的时候，碗中始终有商品

    public void makeStuff(ReentrantLock lock,String name){
        lock.lock();
        stuff++;
        System.out.println("生产者："+name+"生产完成，商品剩余"+stuff+"个");
        lock.unlock();
    }

    public void consumeStuff(ReentrantLock lock,String name){
        lock.lock();
        if (stuff > 0){
            safeLock.lock();// 在嵌套一个锁，保证消费的时候有商品消费，没有的话，这个线程会挂起
            stuff--;
            System.out.println("消费者："+name+"消费完毕，剩余货物："+stuff+"个");
            safeLock.unlock();
        }
        lock.unlock();
    }
}
