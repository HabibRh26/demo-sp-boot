package com.example.restapicrud.service;

import com.example.restapicrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> saveEmployees(List<Employee> employees);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    Employee updateEmployeeAlt(Employee employee);
    void deleteEmployee(long id);
}
