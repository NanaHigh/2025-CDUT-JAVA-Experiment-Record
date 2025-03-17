package Ex8;

import java.lang.Thread;
import Ex8.Depends.*;

public class ex8_1 {
    public static void main(String[] args) {
        RaceStatus status = new RaceStatus();
        
        // 创建线程容器
        Thread[] threads = new Thread[2];
        
        // 先创建兔子线程（占位）
        threads[1] = new Thread();
        // 创建乌龟线程（传入兔子线程引用）
        threads[0] = new Thread(new Turtle(status, threads[1]));
        // 创建真正的兔子线程（传入乌龟线程引用）
        threads[1] = new Thread(new Rabbit(status, threads[0]));

        // 启动比赛
        threads[0].start();
        threads[1].start();

        // 等待比赛结束
        try {
            threads[0].join();
            threads[1].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}