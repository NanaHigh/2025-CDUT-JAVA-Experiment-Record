package Ex6;

import java.lang.System;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ex6_1 {
    public static void main(String[] args) {
        // 文件路径
        String filePath = "./Ex6/test.txt";

        // 使用 try-with-resources 自动关闭资源
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("文件内容如下：");
            // 逐行读取文件内容
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // 捕获并处理 IO 异常
            System.err.println("读取文件时发生错误：" + e.getMessage());
        }
    }
}