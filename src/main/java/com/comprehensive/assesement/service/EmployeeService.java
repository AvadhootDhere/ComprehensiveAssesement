package com.comprehensive.assesement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprehensive.assesement.entity.Employee;
import com.comprehensive.assesement.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	 public List<Employee> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Employee emp) {
	        repo.save(emp);
	    }
	     
	    public Employee get(Integer id) {
	        return repo.findById(id).get();
	    }
	    
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }

}
