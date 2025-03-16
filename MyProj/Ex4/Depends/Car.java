package Ex4.Depends;

import java.lang.System;

public class Car extends Vehicle {
    public Car(String vendorName, String engineType, String serialNumber, String manufactDate) {
        super(vendorName, engineType, serialNumber, manufactDate);
    }
    /// 打印汽车信息
    public void showInfo() {
        System.out.println("汽车信息如下：");
        System.out.println("厂商名称：" + vendorName);
        System.out.println("发动机类型：" + engineType);
        System.out.println("序列号：" + serialNumber);
        System.out.println("生产日期：" + manufactDate);
    }
    /// 汽车启动
    public void drive() {
        System.out.println("Tom乘坐了汽车");
        System.out.println("汽车的速度是100km/h");
    }
    /// 汽车停止
    public void stop() {
        System.out.println("汽车停止了");
    }
}
