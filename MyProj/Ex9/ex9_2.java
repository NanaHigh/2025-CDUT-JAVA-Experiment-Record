package Ex9;

import Ex9.Depends.*;

public class ex9_2 {
    public static void main(String[] args) {
        // 创建三个窗口线程
        Thread window1 = new Thread(new TicketWindow(), "窗口1");
        Thread window2 = new Thread(new TicketWindow(), "窗口2");
        Thread window3 = new Thread(new TicketWindow(), "窗口3");

        // 启动线程
        window1.start();
        window2.start();
        window3.start();

        // 等待所有线程结束
        try {
            window1.join();
            window2.join();
            window3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("=== 所有票已售完 ===");
    }
}