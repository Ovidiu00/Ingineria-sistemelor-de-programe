package isp.lab4.exercise6;

import isp.lab4.exercise6.Factories.ComissionEmployeeFactory;
import isp.lab4.exercise6.Factories.HourlyEmployeeFactory;
import isp.lab4.exercise6.Factories.SalariedEmployeeFactory;

public class Exercise6 {
    public static void main(String[] args){


        Employee salariedEmployee = new SalariedEmployeeFactory().createEmployee();
        Employee hourlyEmployee =  new HourlyEmployeeFactory().createEmployee();
        Employee comissionEmployee = new ComissionEmployeeFactory().createEmployee();

        System.out.println("Salaried employee : " + salariedEmployee.getPaymentAmount() + "\n");
        System.out.println("Hourly employee : " + hourlyEmployee.getPaymentAmount() + "\n");
        System.out.println("Comission employee : " + comissionEmployee.getPaymentAmount() + "\n");


        Employee[] employees = new Employee[6];
        employees[0] = employees[1] = new SalariedEmployeeFactory().createEmployee();
        employees[2] = employees[3] = new HourlyEmployeeFactory().createEmployee();
        employees[4] = employees[5] = new ComissionEmployeeFactory().createEmployee();

        Double sum = 0.0;
        for(Employee employee : employees){
            sum += employee.getPaymentAmount();
        }
        System.out.println("Total sum is " + sum);
    }
}
