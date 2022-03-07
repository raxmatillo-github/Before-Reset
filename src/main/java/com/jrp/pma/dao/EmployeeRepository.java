package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jrp.pma.entities.Employee;

@RepositoryRestResource(collectionResourceRel = "apiemployees", path = "apiemployees")
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	@Override
	public List<Employee> findAll();

	public Employee findByEmployeeId(long id);
}
