package Ex8.Depends;

import java.lang.System;
import java.lang.Thread;

// 兔子线程
public class Rabbit implements Runnable {
    private int position;
    private final RaceStatus status;
    private final Thread turtleThread;
    // 赛道总长度
    private static final int TRACK_LENGTH = 1000;
    // 单位时间（毫秒）
    private static final int TIME_UNIT = 1000;

    public Rabbit(RaceStatus status, Thread turtleThread) {
        this.position = 0;
        this.status = status;
        this.turtleThread = turtleThread;
    }

    @Override
    public void run() {
        try {
            while (!status.raceOver && position < TRACK_LENGTH) {
                Thread.sleep(TIME_UNIT);
                position += 5;
                
                synchronized (status) {
                    System.out.println("[兔子] 当前位置：" + position + "米");
                    if (position >= TRACK_LENGTH) {
                        System.out.println("============= 兔子到达终点 =============");
                        status.raceOver = true;
                        turtleThread.interrupt();
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
