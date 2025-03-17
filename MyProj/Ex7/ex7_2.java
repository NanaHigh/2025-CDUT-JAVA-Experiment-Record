package Ex7;

import Ex7.Depends.Quene;
import java.lang.System;

public class ex7_2 {
    public static void main(String[] args) {
        Quene<Integer> q = new Quene<>();
        System.out.println("队列为空：" + q.isEmpty());
        q.inQuene(1);
        q.inQuene(2);
        q.inQuene(3);
        q.showQuene();
        System.out.println("队列为空：" + q.isEmpty());
        q.outQuene();
        q.showQuene();
        q.outQuene();
        q.outQuene();
        System.out.println("队列为空：" + q.isEmpty());
    }
}
