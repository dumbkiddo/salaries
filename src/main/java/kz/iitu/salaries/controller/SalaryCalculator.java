package kz.iitu.salaries.controller;

import kz.iitu.salaries.model.Employee;
import kz.iitu.salaries.model.EmployeeType;
import org.springframework.stereotype.Component;

@Component
public class SalaryCalculator {

    private double salary;
    Employee employee;

    public double calculate(Employee employee){
        if (employee.getEmplType().equals(EmployeeType.SALARIED)){
            salary += employee.getFixedSalary();
        }
        if (employee.getEmplType().equals(EmployeeType.HOURLY)){
            if (employee.getHoursWorked() > 40) {
                salary += ((employee.getHoursWorked()- 40) * (employee.getHourRate()*1.5)) + (40 * employee.getHourRate());
            }
            else {
                salary +=  employee.getHoursWorked() * employee.getHourRate();
            }
        }
        if (employee.getEmplType().equals(EmployeeType.COMMISION)){
            salary += employee.getFixedSalary() * employee.getCommRate();
        }
        if (employee.getEmplType().equals(EmployeeType.SALARIED_COMMISION)){
            salary += employee.getFixedSalary() + (employee.getFixedSalary()*0.1) + (employee.getFixedSalary() * employee.getCommRate());
        }
        return salary;
    }
    public String toString() {
        return this.employee.toString();
    }

}
