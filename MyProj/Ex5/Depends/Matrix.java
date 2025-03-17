package Ex5.Depends;

import java.lang.System;
import java.lang.RuntimeException;

public class Matrix <T extends Comparable<T>> {
    private String name;
    private T[][] data;

    public Matrix(String name, T[][] matrix) {
        this.name = name;
        this.data = matrix;
    }
    /// 查找元素
    public void find(T target) {
        if (data == null || data.length == 0 || data[0].length == 0) 
        throw new RuntimeException("矩阵为空");
        
        int rows = data.length;
        int cols = data[0].length;
        int row = 0;
        int col = cols - 1;  // 从右上角开始搜索

        while (row < rows && col >= 0) {
            T current = data[row][col];
            int cmp = current.compareTo(target);
            
            if (cmp == 0) {
                System.out.println("矩阵"+name+"中找到目标值: " + target);           // 找到目标
                return;
            } else if (cmp > 0) {
                col--;                  // 当前值 > 目标 → 左移列
            } else {
                row++;                  // 当前值 < 目标 → 下移行
            }
        }
        System.out.println("矩阵"+name+"中未找到目标值: " + target);
    }
    /// 打印矩阵的值
    public void print() {
        if (data == null || data.length == 0 || data[0].length == 0)
            throw new RuntimeException("矩阵为空");

        System.out.println("矩阵"+name+"的值为:");
        for (T[] row : data) {
            for (T value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}