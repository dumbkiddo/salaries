package kz.iitu.salaries.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private int id;
    private String name;
    private String type;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name,String type,double salary) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.salary=salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name;
    }
}
