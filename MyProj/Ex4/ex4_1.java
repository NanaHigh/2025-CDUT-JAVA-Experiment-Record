package Ex4;

import Ex4.Depends.*;
import java.lang.System;
import java.util.Scanner;

public class ex4_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = input.nextInt();
        int remainder = num % 3;
        input.close();

        Vehicle vehicle = null;

        switch (remainder) {
            case 0:
                vehicle = new Car("红旗", "内燃机", "123456", "2025-01-01");
                break;
            case 1:
                vehicle = new Train("中国铁路", "电动机", "123456", "2025-01-01");
                break;
            case 2:
                vehicle = new Airplane("波音", "喷气发动机", "123456", "2025-01-01");
                break;
        }
        vehicle.drive();
        vehicle.showInfo();
        vehicle.stop();
    }
}
