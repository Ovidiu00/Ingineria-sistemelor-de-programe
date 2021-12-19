package isp.lab4.exercise6.Factories;

import isp.lab4.exercise6.Employee;
import isp.lab4.exercise6.EmployeeVariants.ComissionEmployee;

public class ComissionEmployeeFactory implements EmployeeFactory {

    @Override
    public Employee createEmployee() {
        return new ComissionEmployee(300,10);
    }
}
