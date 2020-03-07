package kz.iitu.salaries;

import kz.iitu.salaries.controller.CalculateSalary;
import kz.iitu.salaries.model.Employee;
import kz.iitu.salaries.spring.config.SpringConfiguration;
import kz.iitu.salaries.spring.dao.EmployeeDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Scanner scan = new Scanner(System.in);
        EmployeeDAO employee = context.getBean(EmployeeDAO.class);

        for (Employee e : employee.getAllEmployees()) {
            System.out.println(e);
        }

        CalculateSalary cs = context.getBean(CalculateSalary.class);
        System.out.println("Choose an employee to calculate salary: ");
        int choice = scan.nextInt();

        if (employee.getEmployeeById(choice).getType().equalsIgnoreCase("regular")){
            System.out.println("Salary: " + cs.calculateRegular());
        }
        if (employee.getEmployeeById(choice).getType().equalsIgnoreCase("hourly")){
            System.out.println("Enter a number of worked hours: (payment per hour is 3000)");
            int numberOfHours = scan.nextInt();
            employee.update(employee.getEmployeeById(choice), choice, cs.calculateHourly(numberOfHours));
            System.out.println("Salary: " + cs.calculateHourly(numberOfHours));
        }
        if (employee.getEmployeeById(choice).getType().equalsIgnoreCase("commissioned")){
            System.out.println("Enter a number of sales: ");
            int sales = scan.nextInt();
            System.out.println("Enter an earned percentage: ");
            int percentage = scan.nextInt();
            employee.update(employee.getEmployeeById(choice), choice, cs.calculateCommissioned(sales,percentage));
            System.out.println("Salary: " + cs.calculateCommissioned(sales,percentage));
        }
        if (employee.getEmployeeById(choice).getType().equalsIgnoreCase("sCommissioned")){
            System.out.println("Enter a number of sales: ");
            int sales = scan.nextInt();
            System.out.println("Enter an earned percentage: ");
            int percentage = scan.nextInt();
            employee.update(employee.getEmployeeById(choice), choice, cs.calculateSalaryCommissioned(sales,percentage));
            System.out.println("Salary: " + cs.calculateSalaryCommissioned(sales,percentage));
        }
        context.close();
    }
}