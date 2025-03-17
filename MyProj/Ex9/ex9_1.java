package Ex9;

import Ex9.Depends.*;

public class ex9_1 {
    public static void main(String[] args) {
        Fridge fridge = new Fridge();

        // 创建生产人员和销售人员线程
        Thread workerThread = new Thread(new Worker(fridge), "生产人员");
        Thread salserThread = new Thread(new Salser(fridge), "销售人员");

        // 启动线程
        workerThread.start();
        salserThread.start();

        // 模拟运行一段时间后终止
        try {
            Thread.sleep(60000); // 运行60秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 中断线程
        workerThread.interrupt();
        salserThread.interrupt();
        System.out.println("模拟结束");
    }
}