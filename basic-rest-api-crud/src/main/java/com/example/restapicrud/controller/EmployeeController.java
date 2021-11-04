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
    @CrossOrigin(origins = "*")
   @PostMapping("/api/employee")
    public ResponseEntity<Employee> saveEmp(@RequestBody Employee emp){
        return new ResponseEntity<Employee>(empService.saveEmployee(emp), HttpStatus.CREATED);
    }
//    create list of employee REST API
    @CrossOrigin(origins = "*")
    @PostMapping("/api/employees")
    public ResponseEntity<List<Employee>> saveEmployees(@RequestBody List<Employee> employees){
        System.out.println(employees);
        return new ResponseEntity<List<Employee>>(empService.saveEmployees(employees), HttpStatus.CREATED);
    }
//    getting employee REST API
    @CrossOrigin(origins = "*")
    @GetMapping("/api/employees")
    public List<Employee> getAllEmp(){
       return empService.getAllEmployees();
    }
//    find by employee id REST API

    @CrossOrigin(origins = "*")
    @GetMapping("/api/employees/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") long empId){
      return new ResponseEntity<Employee>(empService.getEmployeeById(empId), HttpStatus.OK);
    }

//   Way-1: update employee by Id REST API
//    @CrossOrigin(origins = "*")
//    @PutMapping("/api/employees/{id}")
//    public ResponseEntity<Employee> updateEmp(@PathVariable("id") long id, @RequestBody Employee emp){
//       return  new ResponseEntity<Employee>(empService.updateEmployee(emp, id), HttpStatus.OK);
//    }

    // Way-2: update employee by Object REST API
    @CrossOrigin(origins = "*")
    @PutMapping("/api/employee")
    public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp){
        return  new ResponseEntity<Employee>(empService.updateEmployeeAlt(emp), HttpStatus.OK);
    }

//    delete employee id REST API
    @CrossOrigin(origins = "*")
    @DeleteMapping("/api/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
       empService.deleteEmployee(id);
       return  new ResponseEntity<String>("Deleted Successfully.",HttpStatus.NO_CONTENT);
    }
//    search employee by firstName - REST API
    @CrossOrigin(origins = "*")
    @GetMapping("/api/employees/first-name/{firstName}")
    public ResponseEntity<?> searchEmployeeByFirstName(@PathVariable String firstName){
        return this.empService.searchEmployeeByFirstName(firstName);

    }
    //    search employee by lastName - REST API
    @CrossOrigin(origins = "*")
    @GetMapping("/api/employees/last-name/{lastName}")
    public ResponseEntity<?> searchEmployeeByLastName(@PathVariable String lastName){
        return this.empService.searchEmployeeByLastName(lastName);

    }

    //    search employee by email- REST API
    @CrossOrigin(origins = "*")
    @GetMapping("/api/employees/email/{email}")
    public ResponseEntity<?> searchEmployeeByEmail(@PathVariable String email){
        return this.empService.searchEmployeeByEmail(email);

    }
//    search substring in all columns- REST API

}
