package com.example.springbootapidemo.repository;

import com.example.springbootapidemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//เป็น Bean โดยอัตโนมัติ
public interface EmployeeDataRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
}
