package Ex8.Depends;

public class ThreadSub implements Runnable {
    private final SharedVal sharedVal;
    private final int threadNum;
    private final String name;

    public ThreadSub(SharedVal sharedVal, int threadNum, String name) {
        this.sharedVal = sharedVal;
        this.threadNum = threadNum;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (!sharedVal.terminateFlag) {
                sharedVal.lock.lock();
                try {
                    // 等待直到轮到自己执行
                    while ((sharedVal.currentStep % 4) != threadNum) {
                        if (sharedVal.terminateFlag) return;
                        sharedVal.condition.await();
                    }

                    // 达到最大步数停止
                    if (sharedVal.currentStep >= sharedVal.maxStep) {
                        sharedVal.terminateFlag = true;
                        sharedVal.condition.signalAll();
                        break;
                    }

                    // 执行减操作
                    sharedVal.i--;
                    System.out.println("线程" + name + "执行了减1操作，当前i值为" + sharedVal.i);

                    // 更新步骤并唤醒其他线程
                    sharedVal.currentStep++;
                    sharedVal.condition.signalAll();

                } finally {
                    sharedVal.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("线程" + name + "已终止");
    }
}