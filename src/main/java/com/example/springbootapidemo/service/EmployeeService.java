package com.example.springbootapidemo.service;

import com.example.springbootapidemo.entity.Employee;
import com.example.springbootapidemo.exception.DataNotFoundexception;
import com.example.springbootapidemo.repository.EmployeeDataRepository;
import com.example.springbootapidemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired //ต้องมี @Repository ตรง class ก่อน
    EmployeeRepository repository;

    @Autowired
    EmployeeDataRepository dataRepository;

    public void createEmployee(Employee request){
        System.out.println("** execute create repository");

        System.out.println("*** call employee repository");
        dataRepository.save(request);
    }

    public List<Employee> listAllEmployee() {
        return dataRepository.findAll();
    }

    public Employee getEmployee(Integer id){
        return dataRepository.findById(id).orElseThrow(()-> new DataNotFoundexception("ไม่พบข้อมูล"));
    }

    public Employee updateEmployee(Integer id, Employee request) {
        Employee employee = getEmployee(id);
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());

        return dataRepository.save(employee);
    }

    public List<Employee> search(Employee request) {
        return dataRepository.findByFirstNameAndLastName(request.getFirstName(), request.getLastName());
    }

    public Employee deleteEmployee(Integer id) {
        Employee employee = getEmployee(id);
        dataRepository.deleteById(id);
        return employee;
    }
}
