package Ex9.Depends;

import java.util.Random;

public class Salser implements Runnable {
    private final Fridge fridge;
    private final Random random = new Random();

    public Salser(Fridge fridge) {
        this.fridge = fridge;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int amount = random.nextInt(11); // 随机销售0-10个面包
                if (amount > 0) {
                    fridge.sell(amount); // 销售面包
                }
                int waitTime = random.nextInt(31); // 随机等待0-30秒
                Thread.sleep(waitTime * 1000); // 模拟顾客到达时间
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("销售人员被中断");
        }
    }
}