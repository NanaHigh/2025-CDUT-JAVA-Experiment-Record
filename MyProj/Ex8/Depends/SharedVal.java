package Ex8.Depends;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class SharedVal {
    public int currentStep;  // 控制执行顺序
    public int maxStep;     // 最大执行步数
    public int i;            // 共享变量
    public Lock lock;        // 锁
    public Condition condition; // 条件变量
    public boolean terminateFlag; // 终止标志

    public SharedVal() {
        this.currentStep = 0;
        this.maxStep = 10;
        this.i = 0;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
        this.terminateFlag = false;
    }
}
