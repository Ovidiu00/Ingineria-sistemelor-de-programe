package isp.lab4.exercise6.EmployeeVariants;

import isp.lab4.exercise6.Employee;

public class ComissionEmployee extends Employee {

    private double grossSales;
    private double comissionSales;

    public ComissionEmployee(double grossSales, double comissionSales) {
        this.grossSales = grossSales;
        this.comissionSales = comissionSales;
    }

    @Override
    public double getPaymentAmount() {
        return comissionSales * grossSales / 100;
    }

}
