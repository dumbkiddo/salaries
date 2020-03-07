package kz.iitu.salaries.spring.dao;

import kz.iitu.salaries.model.Employee;
import kz.iitu.salaries.model.EmployeeMapper;
import kz.iitu.salaries.spring.event.NotifyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.List;

@Component
public class EmployeeDAO implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_EMPLOYEE = "select * from employee where id = ?";
    private final String SQL_GET_ALL = "select * from employee";
    private final String SQL_UPDATE = "update employee set salary = ? where id = ?";

    @Autowired
    public EmployeeDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Employee getEmployeeById(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[] { id }, new EmployeeMapper());
    }

    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
    }

    public void update(Employee employee, Integer id, double salary){
        jdbcTemplate.update(SQL_UPDATE, salary, id);
        this.eventPublisher.publishEvent(new NotifyEvent(this, employee));
        return;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

}
