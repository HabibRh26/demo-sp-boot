package com.example.restapicrud.service.Impl;

import com.example.restapicrud.entity.Employee;
import com.example.restapicrud.exception.ResourceNotFoundException;
import com.example.restapicrud.repository.EmployeeRepository;
import com.example.restapicrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//    @Autowired
    EmployeeRepository empRepo;

    public EmployeeServiceImpl(EmployeeRepository empRepo) {
        super();
        this.empRepo = empRepo;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return empRepo.save(employee);
    }

    @Override
    public List<Employee> saveEmployees(List<Employee> employees) {
        return empRepo.saveAll(employees);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {

        Optional<Employee> emp = empRepo.findById(id);
        if(emp.isPresent()){
            return emp.get();
        }else{
            throw new ResourceNotFoundException("Employee","Id",id);
//            throw new ResourceNotFoundException("Employee");

        }

    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmp = empRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee","Id",id));
//        ()-> new ResourceNotFoundException("Employee"));
        existingEmp.setEmail(employee.getEmail());
        existingEmp.setFirstName(employee.getFirstName());
        existingEmp.setLastName(employee.getLastName());
        empRepo.save(existingEmp);

        return existingEmp;
    }

    @Override
    public Employee updateEmployeeAlt(Employee employee) {
        return empRepo.save(employee);

    }

    @Override
    public void deleteEmployee(long id) {
    empRepo.findById(id).orElseThrow(()->
            new ResourceNotFoundException("Employee","Id",id));
//        new ResourceNotFoundException("Exception"));
        empRepo.deleteById(id);
    }

    @Override
    public ResponseEntity<?> searchEmployeeByFirstName(String firstName) {
        try {
            return new ResponseEntity<>(empRepo.searchEmpByFirstName(firstName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("First Name Search Error : " + e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> searchEmployeeByLastName(String lastName) {
        try {
            return new ResponseEntity<>(empRepo.searchEmpByLastName(lastName), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Last Name Search Error : " + e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> searchEmployeeByEmail(String email) {
        try {
            return new ResponseEntity<>(empRepo.searchEmpByEmail(email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Email Search Error : " + e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> searchEmployeeByQueryString(String queryWord) {
        try {
            return new ResponseEntity<>(empRepo.searchEmpByQueryWord(queryWord), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Query String Search Error : " + e.toString(), HttpStatus.NOT_FOUND);
        }
    }
}
