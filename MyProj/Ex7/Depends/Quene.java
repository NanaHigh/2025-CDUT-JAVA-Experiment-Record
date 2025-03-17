package Ex7.Depends;

import java.util.ArrayList;
import java.lang.System;
import java.lang.RuntimeException;

public class Quene <T> {
    private int front = 0;
    private int real = 0;
    private ArrayList<T> list = new ArrayList<>();

    /// 入队
    public void inQuene(T t){
        real++;
        list.add(t);
        System.out.println("队列加入元素：" + t);
    }
    /// 出队
    public T outQuene(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        T t = list.getLast();
        list.removeLast();
        System.out.println("队列弹出元素：" + t);
        return t;
    }
    /// 判断是否为空
    public boolean isEmpty(){
        return real == front;
    }
    /// 显示队列
    public void showQuene(){
        System.out.println("队列显示元素：");
        for (T t : list) {
            System.out.println("| " + t + " |");
        }
    }
}
