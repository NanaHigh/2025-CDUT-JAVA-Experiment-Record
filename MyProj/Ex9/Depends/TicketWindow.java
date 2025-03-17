package Ex9.Depends;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketWindow implements Runnable {
    private static final AtomicInteger tickets = new AtomicInteger(30); // 总票数

    @Override
    public void run() {
        while (true) {
            try {
                // 模拟顾客到达时间：0-10秒随机等待
                Thread.sleep((int)(Math.random() * 10000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            // 尝试卖票（CAS操作保证线程安全）
            int current = tickets.get();
            if (current <= 0) {
                System.out.println(Thread.currentThread().getName() + "：票已售罄");
                break;
            }

            if (tickets.compareAndSet(current, current - 1)) {
                System.out.println(Thread.currentThread().getName() + 
                    " 售出1张票，剩余票数：" + (current - 1));
            }
        }
    }
}