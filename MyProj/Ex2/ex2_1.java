package Ex2;

import java.lang.System;

public class ex2_1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            // 添加缩进：每行前i-1个8空格块
            for (int k = 1; k < i; k++) {
                System.out.print("        "); // 8个空格
            }
            // 打印当前行i的乘法式子
            for (int j = i; j <= 9; j++) {
                System.out.printf("%-8s", i + "*" + j + "=" + (i * j));
            }
            System.out.println(); // 换行
        }
    }
}
