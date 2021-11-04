package com.example.restapicrud.repository;

import com.example.restapicrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select * from emp_table where first_name = ?1", nativeQuery = true)
    List<Employee> searchEmpByFirstName(String firstName);

    @Query(value = "select * from emp_table where last_name = ?1", nativeQuery = true)
    List<Employee> searchEmpByLastName(String lastName);

    @Query(value = "select * from emp_table where email = ?1", nativeQuery = true)
    List<Employee> searchEmpByEmail(String email);

    @Query(value = " SELECT * FROM emp_table\n" +
            "WHERE emp_table.first_name LIKE concat('%',?1,'%') \n" +
            "   OR emp_table.last_name  LIKE concat('%',?1,'%') \n" +
            "   OR emp_table.email  LIKE concat('%',?1,'%') \n", nativeQuery = true)
    List<Employee> searchEmpByQueryWord(String queryWord);
}