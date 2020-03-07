package kz.iitu.salaries.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt(1));
        employee.setName(resultSet.getString(2));
        employee.setType(resultSet.getString(3));
        employee.setSalary(resultSet.getDouble(4));
        return employee;
    }
}

