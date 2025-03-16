package Ex2;

import java.lang.System;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex2_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入任意语句: ");
        String sentence = input.nextLine();
        input.close();

        int[] digitCounts = new int[10]; // 存储0-9数字的出现次数
        HashMap<Character, Integer> letterCounts = new HashMap<>(); // 存储字母出现次数

        // 遍历每个字符进行统计
        for (char c : sentence.toCharArray()) {
            if (Character.isDigit(c)) {
                // 统计数字
                digitCounts[c - '0']++;
            } else if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                // 统计英文字母（区分大小写）
                letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
            }
        }

        // 打印数字统计结果
        System.out.println("\n数字出现次数:");
        for (int i = 0; i < digitCounts.length; i++) {
            if (digitCounts[i] > 0) {
                System.out.printf("数字 %d → %d次\n", i, digitCounts[i]);
            }
        }

        // 打印字母统计结果（按字母顺序排序）
        System.out.println("\n字母出现次数:");
        letterCounts.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> System.out.printf("字母 %c → %d次\n", 
                    entry.getKey(), entry.getValue()));
    }
}
