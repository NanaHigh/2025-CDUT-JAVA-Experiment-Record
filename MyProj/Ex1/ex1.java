package Ex1;

import java.lang.System;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个汉字：");
        String str = input.nextLine(); // 获取用户输入的汉字
        input.close();
        char c = str.charAt(0);
        System.out.println("输入的汉字是：" + c);
        int pos = (int) c;
        System.out.println("输入汉字在Unicode表中的位置是：" + pos);
    }
}