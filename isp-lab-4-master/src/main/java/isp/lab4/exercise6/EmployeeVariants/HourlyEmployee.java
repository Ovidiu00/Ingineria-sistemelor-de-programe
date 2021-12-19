package isp.lab4.exercise6.EmployeeVariants;

import isp.lab4.exercise6.Employee;

public class HourlyEmployee extends Employee {

    private double wage;
    private double hours;

    public HourlyEmployee(double wage, double hours) {
        this.wage = wage;
        this.hours = hours;
    }

    @Override
    public double getPaymentAmount() {
        return wage * hours;
    }
}
