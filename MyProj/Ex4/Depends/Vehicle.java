package Ex4.Depends;

/// 交通工具抽象类
public abstract class Vehicle {
    public String vendorName;
    public String engineType;
    public String serialNumber;
    public String manufactDate;

    public abstract void showInfo();
    public abstract void drive();
    public abstract void stop();

    public Vehicle(String vendorName, String engineType, String serialNumber, String manufactDate) {
        this.vendorName = vendorName;
        this.engineType = engineType;
        this.serialNumber = serialNumber;
        this.manufactDate = manufactDate;
    }
}
