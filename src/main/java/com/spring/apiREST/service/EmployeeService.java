package com.spring.apiREST.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.apiREST.model.Employee;
import com.spring.apiREST.repository.EmployeeRepository;

import lombok.Data;

@Service
@Data
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository er;
	
	public Optional<Employee> getEmploye (final Long id){
		
		return er.findById(id);
		
	}
	
	public Iterable<Employee> getEmployees (){
		
		return er.findAll();
	}
	
	public void deleteEmployee (final Long id) {
		
		 er.deleteById(id);
	}
	
	public Employee saveOrupdateEmployee (Employee employee) {
		
		Employee savedEmployee = er.save(employee);
		return savedEmployee;
	}


}
