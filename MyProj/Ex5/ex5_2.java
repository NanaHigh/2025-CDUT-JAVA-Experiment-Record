package Ex5;

import Ex5.Depends.Matrix;

public class ex5_2 {
    public static void main(String[] args) {
        // 测试 Double 类型矩阵
        Double[][] doubleMatrix = {
            {1.1, 4.4, 7.7},
            {2.2, 5.5, 8.8},
            {3.3, 6.6, 9.9}
        };
        Matrix<Double> matrix1 = new Matrix<>("matrix1", doubleMatrix);
        matrix1.print();
        matrix1.find(5.5);   // true
        matrix1.find(3.3);   // true
        matrix1.find(10.0);  // false

        // 测试 Integer 类型矩阵
        Integer[][] intMatrix = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };
        Matrix<Integer> matrix2 = new Matrix<>("matrix2", intMatrix);
        matrix2.print();
        matrix2.find(5);    // true
        matrix2.find(0);    // false
    }
}
