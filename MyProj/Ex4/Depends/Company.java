package Ex4.Depends;

import java.lang.String;
import java.lang.System;

public class Company {
    public Employee [] employees;
    public Company(Employee [] employees) {
        this.employees = employees;
    }
    public void showYearlySalaries() {
        double salaries = 0;
        int weekworkers = 0;
        int monthworkers = 0;
        int yearWorkers = 0;
        for (Employee employee : employees) {
            salaries += employee.earings();
            if (employee instanceof WeekWorker) {
                weekworkers++;
            } else if (employee instanceof MonthWorker) {
                monthworkers++;
            } else if (employee instanceof YearWorker) {
                yearWorkers++;
            }
        }
        System.out.println("公司中按周工作的员工有： " + weekworkers + " 人");
        System.out.println("公司中按月工作的员工有： " + monthworkers + " 人");
        System.out.println("公司中按年工作的员工有： " + yearWorkers + " 人");
        System.out.println("公司需要支付的总工资为： " + String.format("%.2f", salaries));
    }
}
