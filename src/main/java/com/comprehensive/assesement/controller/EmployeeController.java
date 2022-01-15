package com.comprehensive.assesement.controller;

import java.lang.annotation.Repeatable;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comprehensive.assesement.entity.Employee;
import com.comprehensive.assesement.service.EmployeeService;

@RestController
public class EmployeeController {
	int i;
	Employee e;
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("")
	public String def() {
		return "Welcome";
	}
	@GetMapping("/employees")
	public String def1() {
		return "Welcome";
	}
	
	@GetMapping("/employees/getAll")
	public List<Employee> list() {
	    return service.listAll();
	}
	@GetMapping("/employees/getSortedbySalary")
	public List<Employee> list1() {
	    List<Employee> l1=service.listAll();
	    Collections.sort(l1);
	    return l1;
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> get(@PathVariable Integer id) {
	    try {
	        Employee emp = service.get(id);
	        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	    }      
	}
	@PostMapping("/employees/add")
	public ResponseEntity<Employee> add(@RequestBody Employee emp) {
		
			try{if(!checkId(emp))
			{
				throw new DBException();
			}
			else {
				service.save(emp);
				return new ResponseEntity<Employee>(emp,HttpStatus.OK);
			}
			}catch(DBException ex)
			{
				System.out.println("Employee already Exists in Database");
				return new ResponseEntity<Employee>(emp,HttpStatus.BAD_REQUEST);
				
			}
		}
	
	@PutMapping("/employees/update/{id}")
	public ResponseEntity<Employee> update(@RequestBody Employee emp, @PathVariable Integer id) {
	    try {
	        Employee emp1=service.get(id);
	        emp1.setSalary(emp.getSalary());
	        service.save(emp1);
	        return new ResponseEntity<>(emp1,HttpStatus.OK);
	    } catch (NoSuchElementException	e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	boolean checkId(Employee emp) {
		int flag=0;
		List <Employee> l1=service.listAll();
		for(int i=0;i<l1.size();i++)
		{
			Employee obj=l1.get(i);
			if(obj.getId() == emp.getId()) 
				flag=1;
			else
				flag=0;		
			}
		if(flag==1)
			return false;
		else
			return true;
		}
	}

	
	
	
	


