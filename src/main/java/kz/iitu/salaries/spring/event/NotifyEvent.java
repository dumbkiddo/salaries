package kz.iitu.salaries.spring.event;

import kz.iitu.salaries.model.Employee;
import org.springframework.context.ApplicationEvent;

public class NotifyEvent extends ApplicationEvent {

    private Employee employee;

    public NotifyEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}

