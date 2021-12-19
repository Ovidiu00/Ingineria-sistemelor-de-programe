package isp.lab4.exercise6.EmployeeVariants;

import isp.lab4.exercise6.Employee;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPaymentAmount() {
        return weeklySalary * 4;
    }
}
