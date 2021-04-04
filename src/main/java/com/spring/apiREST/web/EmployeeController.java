package com.spring.apiREST.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.apiREST.model.Employee;
import com.spring.apiREST.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	/**
	 * Read - Get all employees
	 * @return - An Iterable object of Employee full filled
	 */
	@GetMapping("/employees")
	public Iterable<Employee> allEmployee(){
		
		return es.getEmployees();
	}
	
	/**
	 * Add new employee
	 * @param employee object
	 * return employe saved
	 */
	@PostMapping("/add")
	public Employee addEmployee (@RequestBody Employee employee) {
		
		return es.saveOrupdateEmployee(employee);
	}
	
	/**
	 * get one employee
	 * @param Id
	 * return employee
	 */
	@GetMapping("/employee/{id}")
	public Employee oneEmployee (@PathVariable("id") final Long id) {
		
		Optional<Employee> employee = es.getEmploye(id);
		
		if(employee.isPresent()) {
			
			return employee.get();
		}else {
			
			return null;
		}
	}
	
	/**
	 * update employee
	 * @param id
	 * @employee
	 * return employee update
	 */
	@PutMapping("/employee/{id}")
	public Employee updateEmployee (@RequestBody Employee employee, @PathVariable("id") final Long id) {
		
		Optional<Employee> emp = es.getEmploye(id);
		
		if(emp.isPresent()) {
			
			Employee currentEmployee = emp.get();
			
			String firstName = employee.getFirstName();
			if( firstName != null ) {
				currentEmployee.setFirstName(firstName);
			}
			
			String lastName = employee.getLastName();
			if( lastName != null ) {
				currentEmployee.setLastName(lastName);
			}
			
			String mail = employee.getMail();
			if( mail != null ) {
				currentEmployee.setMail(mail);
			}
			
			String password = employee.getPassword();
			if( password != null ) {
				currentEmployee.setPassword(password);
			}
			
			es.saveOrupdateEmployee(currentEmployee);
			return currentEmployee;
		} else {
			return null;
		}
	}
	
	/**
	 * delete one employee
	 * @param Id
	 */
	@DeleteMapping("/employee/{id}")
	public void delete (@PathVariable("id") final Long id) {
		es.deleteEmployee(id);
	}

}
