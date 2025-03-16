package Ex4.Depends;

import java.lang.System;

public class Train extends Vehicle{
    public Train(String vendorName, String engineType, String serialNumber, String manufactDate) {
        super(vendorName, engineType, serialNumber, manufactDate);
    }
    /// 打印火车信息
    public void showInfo() {
        System.out.println("火车信息如下：");
        System.out.println("厂商名称：" + vendorName);
        System.out.println("发动机类型：" + engineType);
        System.out.println("序列号：" + serialNumber);
        System.out.println("生产日期：" + manufactDate);
    }
    /// 火车行驶
    public void drive() {
        System.out.println("Tom乘坐了火车");
        System.out.println("火车的速度是200km/h");
    }
    /// 火车停车
    public void stop() {
        System.out.println("火车到站了");
    }
}
