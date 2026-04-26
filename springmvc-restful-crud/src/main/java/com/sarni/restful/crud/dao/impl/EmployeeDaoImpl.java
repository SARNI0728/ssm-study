package com.sarni.restful.crud.dao.impl;

import com.sarni.restful.crud.dao.EmployeeDao;
import com.sarni.restful.crud.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Employee getEmployeeById(Long id) {
        String sql = "select * from employee where id = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), id);
        return employee;
    }

    @Override
    public void insertEmployee(Employee employee) {
        String sql = "insert into " +
                "employee(name, age, email, gender, address, salary) " +
                "values(?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getGender(),
                employee.getAddress(),
                employee.getSalary()
        );
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "update employee " +
                "set name = ?, " +
                "age = ?, " +
                "email = ?, " +
                "gender = ?, " +
                "address = ?, " +
                "salary = ? " +
                "where " +
                "id = ?";
        jdbcTemplate.update(sql,
                employee.getName(),
                employee.getAge(),
                employee.getEmail(),
                employee.getGender(),
                employee.getAddress(),
                employee.getSalary(),
                employee.getId()
        );
    }

    @Override
    public void deleteEmployeeById(Long id) {
        String sql = "delete from employee where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
    }
}
