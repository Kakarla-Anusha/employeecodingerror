/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import javax.swing.tree.RowMapper;

import com.example.employee.model.EmployeeRowMapper;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeH2Service implements EmployeeRepository {
    @Autowired
    public JdbcTemplate db;

    @Override
    public ArrayList<Employee> getEmployees()

    {
        List<Employee> employeeList = db.query("select * from EMPLOYEELIST", new EmployeeRowMapper());
        ArrayList<Employee> employees = new ArrayList<>(employeeList);
        return employees;

    }

    @Override
    public Employee employeeById(int employeeId) {
        try {
            Employee employeebyid = db.queryForObject("select * from EMPLOYEELIST where employeeId=?",
                    new EmployeeRowMapper(), employeeId);
            return employeebyid;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}
