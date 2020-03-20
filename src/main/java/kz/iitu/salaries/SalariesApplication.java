package kz.iitu.salaries;

import kz.iitu.salaries.controller.SalaryCalculator;
import kz.iitu.salaries.model.Employee;
import kz.iitu.salaries.model.EmployeeRepository;
import kz.iitu.salaries.model.EmployeeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SalariesApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SalariesApplication.class);
    @Autowired
    private EmployeeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SalariesApplication.class, args);
    }

    public void run(String... args) {

        Employee e = repository.save(new Employee(1L,"Regular employee",100000,0,0,0,EmployeeType.SALARIED));
        Employee e2 = repository.save(new Employee(2L,"Hourly employee",0,1500,45,0,EmployeeType.HOURLY));
        Employee e3 = repository.save(new Employee(3L,"Commissioned employee",100000,0,0,0.5f,EmployeeType.COMMISION));
        Employee e4 = repository.save(new Employee(4L,"Salaried Commissioned employee",120000,0,0,0.5f,EmployeeType.SALARIED_COMMISION));

        System.out.println("\nList all employees: ");
        repository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nFind employee by ID: ");
        repository.findById(4l).ifPresent(x -> System.out.println(x));

        SalaryCalculator cs = new SalaryCalculator();
        System.out.println("Salary is: " + cs.calculate(e4));
    }
}
