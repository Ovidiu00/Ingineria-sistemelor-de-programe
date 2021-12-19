package isp.lab4.exercise6.Factories;

import isp.lab4.exercise6.Employee;
import isp.lab4.exercise6.EmployeeVariants.SalariedEmployee;

public class SalariedEmployeeFactory implements   EmployeeFactory{

    @Override
    public Employee createEmployee() {
       return new SalariedEmployee(400);
    }


}
