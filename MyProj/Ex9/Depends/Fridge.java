package Ex9.Depends;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fridge {
    private final int capacity = 20; // 冰箱容量
    private int breadCount = 0;      // 当前面包数量
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();  // 冰箱未满条件
    private final Condition notEmpty = lock.newCondition(); // 冰箱非空条件

    // 生产面包
    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (breadCount >= capacity) {
                System.out.println("冰箱已满，生产人员等待...");
                notFull.await(); // 冰箱满时等待
            }
            breadCount++;
            System.out.println("生产了一个面包，当前面包数量：" + breadCount);
            notEmpty.signal(); // 通知销售人员可以销售
        } finally {
            lock.unlock();
        }
    }

    // 销售面包
    public void sell(int amount) throws InterruptedException {
        lock.lock();
        try {
            while (breadCount < amount) {
                System.out.println("面包不足，销售人员等待...");
                notEmpty.await(); // 面包不足时等待
            }
            breadCount -= amount;
            System.out.println("销售了" + amount + "个面包，当前面包数量：" + breadCount);
            notFull.signal(); // 通知生产人员可以生产
        } finally {
            lock.unlock();
        }
    }

    // 获取当前面包数量
    public int getBreadCount() {
        return breadCount;
    }
}