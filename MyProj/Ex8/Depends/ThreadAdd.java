package Ex8.Depends;

public class ThreadAdd implements Runnable {
    private final SharedVal sharedVal;
    private final int threadNum;
    private final String name;

    public ThreadAdd(SharedVal sharedVal, int threadNum, String name) {
        this.sharedVal = sharedVal;
        this.threadNum = threadNum;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // 当共享变量的终止标志为false时，继续执行
            while (!sharedVal.terminateFlag) {
                // 获取共享变量的锁
                sharedVal.lock.lock();
                try {
                    // 等待直到轮到自己执行
                    while ((sharedVal.currentStep % 4) != threadNum) {
                        // 如果共享变量的终止标志为true，则返回
                        if (sharedVal.terminateFlag) return;
                        // 等待直到被唤醒
                        sharedVal.condition.await();
                    }

                    // 达到最大步数停止
                    if (sharedVal.currentStep >= sharedVal.maxStep) {
                        // 设置共享变量的终止标志为true
                        sharedVal.terminateFlag = true;
                        // 唤醒所有等待的线程
                        sharedVal.condition.signalAll();
                        break;
                    }

                    // 执行加操作
                    sharedVal.i++;
                    System.out.println("线程" + name + "执行了加1操作，当前i值为" + sharedVal.i);

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