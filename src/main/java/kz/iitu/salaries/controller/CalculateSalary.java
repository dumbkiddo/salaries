package kz.iitu.salaries.controller;

import kz.iitu.salaries.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class CalculateSalary {

    private double salary;
    private double baseSalary = 100000;
    private double paymentPerHour = 3000;
    private int baseHours = 40;
    Employee employee;

    public CalculateSalary(Employee employee) {
        this.employee = employee;
    }

    public double calculateRegular(){
        this.salary = baseSalary;
        return salary;
    }

    public double calculateHourly(int hours){
        if (hours > baseHours){
            this.salary = ((hours-40)*(paymentPerHour*1.5)) + baseHours * paymentPerHour;
        }
        else {
            this.salary = hours*paymentPerHour;
        }
        return salary;
    }

    public double calculateCommissioned(double sales,double percentage){
        this.salary = sales * percentage/100;
        return salary;
    }

    public double calculateSalaryCommissioned(double sales, double percentage){
        //this.salary = baseSalary + (sales*percentage);
        this.salary = baseSalary + (baseSalary * 0.1) + (sales * percentage/100);
        return salary;
    }

    public String toString() {
        return this.employee.toString();
    }
}
