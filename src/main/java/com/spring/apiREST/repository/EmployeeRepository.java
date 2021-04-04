package com.spring.apiREST.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.apiREST.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
