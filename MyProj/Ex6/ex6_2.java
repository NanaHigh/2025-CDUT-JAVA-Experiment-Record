package Ex6;

import java.util.Scanner;
import java.lang.System;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map;
import java.util.LinkedHashMap;

public class ex6_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入网址：");
        String url = input.nextLine().toLowerCase(); // 统一转为小写处理
        input.close();

        // 用正则表达式匹配所有由字母组成的单词
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(url);
        
        // 统计单词出现次数
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        int totalWords = 0;

        while (matcher.find()) {
            String word = matcher.group();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            totalWords++;
        }

        // 打印结果
        System.out.println("总单词数量：" + totalWords);
        System.out.println("各单词出现次数：");
        wordCount.forEach((word, count) -> 
            System.out.println(word + " -> " + count)
        );
    }
}
