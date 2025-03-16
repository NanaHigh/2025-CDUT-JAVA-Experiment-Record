package Ex3.Depends;

import java.lang.System;

public class Family {
    public int number = 0;
    public int water = 0;
    public Well well;

    public Family(int number, Well well) {
        this.number = number;
        this.water = number;
        this.well = well;
    }

    /// 喝水并打印信息
    public void Drink() {
        if (well.water >= water) {
            well.water -= water;
            System.out.println("我是第 " + number + " 户，我喝了 " + water + " 升水， 井里还剩 " + well.water + " 升水");
        } else {
            System.out.println("我是第 " + number + " 户，我需要喝 " + water + " 升水， 但井里只剩 " + well.water + " 升水");
        }
    }
}
