package Ex8.Depends;

public class ThreadAdd implements Runnable {
    private final SharedVal sharedVal;
    private final int threadNum;
    private final String name;

    public ThreadAdd(SharedVal sharedVal, int threadNum,  String name) {
        this.sharedVal = sharedVal;
        this.threadNum = threadNum;
        this.name = name;
    }

    public void run() {
        while (true) {
            sharedVal.lock.lock();
            try {
                // 等待直到轮到自己执行
                while ((sharedVal.currentStep % 4) != threadNum) {
                    sharedVal.condition.await();
                }

                // 达到最大步数停止
                if(sharedVal.currentStep > sharedVal.maxStep) {
                    Thread.currentThread().interrupt();
                    break;
                }

                // 执行操作
                sharedVal.i++;

                // 打印当前i值
                System.out.println("线程" + name + "执行了加1的操作，当前i值为" + sharedVal.i);

                // 更新步骤并唤醒其他线程
                sharedVal.currentStep++;
                sharedVal.condition.signalAll();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                sharedVal.lock.unlock();
            }
        }
    }
}
