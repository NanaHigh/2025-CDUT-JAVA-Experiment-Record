package Ex8;

import Ex8.Depends.*;

public class ex8_2 {
    public static void main(String[] args) {
        SharedVal sharedVal = new SharedVal();
        System.out.println("i的初始值为" + sharedVal.i);

        // 创建线程任务
        ThreadAdd A = new ThreadAdd(sharedVal, 0, "A");
        ThreadAdd B = new ThreadAdd(sharedVal, 1, "B");
        ThreadSub C = new ThreadSub(sharedVal, 2, "C");
        ThreadSub D = new ThreadSub(sharedVal, 3, "D");

        // 启动线程
        new Thread(A).start();
        new Thread(B).start();
        new Thread(C).start();
        new Thread(D).start();
    }
}