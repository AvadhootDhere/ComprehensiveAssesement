package com.comprehensive.assesement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comprehensive.assesement.entity.Employee;

public interface EmployeeRepository extends JpaRepository <Employee,Integer>{

}
