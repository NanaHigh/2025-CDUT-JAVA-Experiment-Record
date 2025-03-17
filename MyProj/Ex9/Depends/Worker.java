package Ex9.Depends;

public class Worker implements Runnable {
    private final Fridge fridge;

    public Worker(Fridge fridge) {
        this.fridge = fridge;
    }

    @Override
    public void run() {
        try {
            while (true) {
                fridge.produce(); // 生产一个面包
                Thread.sleep(1000); // 生产一个面包需要1秒
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("生产人员被中断");
        }
    }
}