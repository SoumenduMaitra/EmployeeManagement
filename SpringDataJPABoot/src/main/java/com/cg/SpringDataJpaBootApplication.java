package com.cg;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dto.EmpDto;
import com.cg.entity.Emp;
import com.cg.service.IEmpService;

@SpringBootApplication
public class SpringDataJpaBootApplication implements CommandLineRunner{
	@Autowired
    private IEmpService service;
    
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaBootApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("View all employees ---------------------------");
		service.viewEmployee().forEach(e->System.out.println(e));
		System.out.println("view employee by ID---------------------------");
		Emp emp=service.viewEmployee(2);
		System.out.println(emp);
		EmpDto empdto=new EmpDto("Rounack",17000,LocalDate.of(2017, 8, 21),"hr");
		int eid=service.addEmployee(empdto);
		System.out.println(eid);
	}

}
