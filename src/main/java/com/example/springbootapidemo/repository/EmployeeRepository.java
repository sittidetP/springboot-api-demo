package com.example.springbootapidemo.repository;

import com.example.springbootapidemo.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void createEmployee(){
        System.out.println("*** save employee to database");
    }

    public List<Employee> listAllEmployee(){
        Query query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Transactional
    public void save(Employee employee){
        entityManager.persist(employee);
    }
}
