package com.example.restapicrud.controller;

import com.example.restapicrud.entity.Employee;
import com.example.restapicrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService empService;

//    create employee REST API
   @PostMapping("/api/employees")
    public ResponseEntity<Employee> saveEmp(@RequestBody Employee emp){
        return new ResponseEntity<Employee>(empService.saveEmployee(emp), HttpStatus.CREATED);
    }
//    getting employee REST API
    @GetMapping("/api/employees/all")
    public List<Employee> getAllEmp(){
       return empService.getAllEmployees();
    }
//    find by employee id REST API
    @GetMapping("/api/employees/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") long empId){
      return new ResponseEntity<Employee>(empService.getEmployeeById(empId), HttpStatus.OK);
    }
//    update employee by Id REST API
    @PutMapping("/api/employees/{id}")
    public ResponseEntity<Employee> updateEmp(@PathVariable("id") long id, @RequestBody Employee emp){
       return  new ResponseEntity<Employee>(empService.updateEmployee(emp, id), HttpStatus.OK);
    }
//    delete employee id REST API
    @DeleteMapping("/api/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
       empService.deleteEmployee(id);
       return  new ResponseEntity<String>("Deleted Successfully.",HttpStatus.OK);
    }
}
