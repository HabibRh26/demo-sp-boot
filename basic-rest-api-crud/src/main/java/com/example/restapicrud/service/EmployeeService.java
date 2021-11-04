package com.example.restapicrud.service;

import com.example.restapicrud.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> saveEmployees(List<Employee> employees);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    Employee updateEmployeeAlt(Employee employee);
    void deleteEmployee(long id);

    ResponseEntity<?> searchEmployeeByFirstName(String firstName);

    ResponseEntity<?> searchEmployeeByLastName(String lastName);

    ResponseEntity<?> searchEmployeeByEmail(String email);
}
