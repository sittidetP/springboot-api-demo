package com.example.springbootapidemo.controller;

import com.example.springbootapidemo.entity.Employee;
import com.example.springbootapidemo.repository.EmployeeRepository;
import com.example.springbootapidemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    //@Autowired //ต้องมี @Service ตรง class ก่อน
    EmployeeService employeeService;


    public  EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> listAllEmployees() {
        /*
        List<Employee> result =  new ArrayList<>();

        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("James");
        employee.setLastName("Smith");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setFirstName("James2");
        employee2.setLastName("Smith2");


        result.add(employee);
        result.add(employee2);

         */

        return employeeService.listAllEmployee();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployees(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee request){

        System.out.println("id : " + request.getId());
        System.out.println("firstName : " + request.getFirstName());
        System.out.println("lastName : " + request.getLastName());

        System.out.println("call employee service");
        employeeService.createEmployee(request);
        return  request;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee request){
        return employeeService.updateEmployee(id, request);
    }

    @PostMapping("/employees/search")
    public List<Employee> search(@RequestBody Employee request){
        return employeeService.search(request);
    }
}
