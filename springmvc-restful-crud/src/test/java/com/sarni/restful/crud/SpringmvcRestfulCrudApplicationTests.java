package com.sarni.restful.crud;

import com.sarni.restful.crud.dao.EmployeeDao;
import com.sarni.restful.crud.pojo.Employee;
import com.sarni.restful.crud.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringmvcRestfulCrudApplicationTests {
    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmployeeService employeeService;

    @Test
    void testEmployeeService(){
        Employee employee = new Employee();
        employee.setName("wangwu");
        employee.setId(1L);
        employee.setSalary(new BigDecimal(999));
        employeeService.updateEmployee(employee);
    }

    @Test
    void testCRUD() {
        employeeDao.updateEmployee(new Employee(1L, "lisi", 20, "<EMAIL>", "1", "beijing", new BigDecimal(10000)));

        employeeDao.deleteEmployeeById(5L);
    }

    @Test
    void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection(); // 拿到了数据源还要获取这个数据源的连接
        System.out.println(connection);
    }

    @Test
    void contextLoads() {
    }

}
