package Ex4;

import Ex4.Depends.*;
import java.util.Random;

public class ex4_2 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[20];
        Random random = new Random();

        for (int i = 0; i < employees.length; i++) {
            int type = random.nextInt(3); // 生成 0、1、2 分别对应三种类型
            switch (type) {
                case 0:
                    employees[i] = new WeekWorker(); // 上转型为 Employee
                    break;
                case 1:
                    employees[i] = new MonthWorker();
                    break;
                case 2:
                    employees[i] = new YearWorker();
                    break;
            }
        }
        
        Company company = new Company(employees);
        company.showYearlySalaries();
    }
}
