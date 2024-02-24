/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here
package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.employee.service.EmployeeH2Service;
import com.example.employee.model.Employee;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeH2Service employeeh2service;

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees() {
        return employeeh2service.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee employeeById(@PathVariable("employeeId") int employeeId) {
        return employeeh2service.employeeById(employeeId);
    }
}
