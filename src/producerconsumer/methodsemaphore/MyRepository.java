package producerconsumer.methodsemaphore;

import java.util.Objects;
import java.util.concurrent.Semaphore;

public class MyRepository {

    private int capability;
    private Semaphore full,empty,mutex;
    private int count = 0;

    public int getCapability() {
        return capability;
    }

    public MyRepository(int capability){
        this.capability = capability;
        full = new Semaphore(0);
        empty = new Semaphore(capability);
        mutex = new Semaphore(1);
    }

    public void add(Object apple, String name) throws InterruptedException{
        empty.acquire();//添加之前，等待一个空位，没有就等待【生产者与消费者之间的同步操作】
        mutex.acquire();//防止多个工人同时操作临界区【生产者之间的对于临界资源的互斥】

        count++;
        System.out.println(name+"：当前产品还有"+count+"个产品");

        mutex.release();//解除临界区的占用
        full.release();//生产之后，告诉消费者，可以消费了【生产者与消费者之间的同步】
    }

    public void remove(Object apple,String name) throws InterruptedException{
        full.acquire();// 消费之前，查看是不是有商品，没有就等待【生产者与消费者之间的同步操作】
        mutex.acquire();

        count--;
        System.out.println(name+ ": 当前产品剩余"+count+"个");

        mutex.release();
        empty.release();//消费完告诉生产者，可以生产了【同步操作】

    }

}
