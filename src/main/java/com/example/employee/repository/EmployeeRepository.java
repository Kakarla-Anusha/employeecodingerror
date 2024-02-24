// Write your code here
package com.example.employee.repository;

import java.util.*;
import com.example.employee.model.Employee;

public interface EmployeeRepository {
    ArrayList<Employee> getEmployees();

    Employee employeeById(int employeeId);

    // Employee addEmployee(Employee employee);

    // Employee updateEmployee(int employeId, Employee employee);

    // void deleteEmployeeId(int employeeId);

}