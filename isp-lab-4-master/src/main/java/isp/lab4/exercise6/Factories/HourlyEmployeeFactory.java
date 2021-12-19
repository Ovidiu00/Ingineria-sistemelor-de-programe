package isp.lab4.exercise6.Factories;

import isp.lab4.exercise6.Employee;
import isp.lab4.exercise6.EmployeeVariants.HourlyEmployee;

public class HourlyEmployeeFactory implements EmployeeFactory{

    @Override
    public Employee createEmployee() {
        return new HourlyEmployee(20,8);
    }
}
