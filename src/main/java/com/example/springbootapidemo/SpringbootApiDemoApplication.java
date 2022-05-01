package com.example.springbootapidemo;

import com.example.springbootapidemo.entity.Employee;
import com.example.springbootapidemo.repository.EmployeeRepository;
import com.example.springbootapidemo.service.EmployeeService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootApiDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringbootApiDemoApplication.class, args);
		/*
		EmployeeService service = context.getBean(EmployeeService.class);
		System.out.println(service);
		service.createEmployee();*/
	}

	@Bean
	public CommandLineRunner initial(EmployeeRepository repository){

		return (args) -> {
			//todo initial data into table EMPLOYEE

			Employee employee1 =  new Employee();
			employee1.setFirstName("john");
			employee1.setLastName("doe");
			repository.save(employee1);

			Employee employee2 =  new Employee();
			employee2.setFirstName("james");
			employee2.setLastName("doe");
			repository.save(employee2);


		};

	}

}
