package Ex4.Depends;

import java.lang.System;

public class Airplane extends Vehicle {
    public Airplane(String vendorName, String engineType, String serialNumber, String manufactDate) {
        super(vendorName, engineType, serialNumber, manufactDate);
    }
    /// 打印飞机信息
    public void showInfo() {
        System.out.println("飞机信息如下：");
        System.out.println("飞机的厂商是" + vendorName);
        System.out.println("飞机的发动机类型是" + engineType);
        System.out.println("飞机的序列号是" + serialNumber);
        System.out.println("飞机的生产日期是" + manufactDate);
    }
    /// 飞机起飞
    public void drive() {
        System.out.println("Tom乘坐了飞机");
        System.out.println("飞机的速度是800km/h");
    }
    /// 飞机降落
    public void stop() {
        System.out.println("飞机降落了");
    }
}
