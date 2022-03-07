package com.jrp.pma.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public List<Employee> getEmployees() {	
		return empRepo.findAll();	
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		return empRepo.findById(id).get();
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee saveEmployee(@RequestBody @Valid Employee employee) {
		return empRepo.save(employee);
	}
	
	@PutMapping("/{id}")
	public Employee update(@RequestBody @Valid Employee employee) {
		return empRepo.save(employee);
	}

	@PatchMapping("/{id}")
	public Employee updatePatch(@PathVariable long id, @RequestBody @Valid Employee employee) {
		Employee emp = empRepo.findById(id).get();
		
		if(employee.getFirstName() != null) {
			emp.setFirstName(employee.getFirstName());
		}
		if(employee.getLastName() != null) {
			emp.setLastName(employee.getLastName());
		}
		if(employee.getEmail() != null) {
			emp.setEmail(employee.getEmail());
		}
		return empRepo.save(emp);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmpById(@PathVariable long id) {
		try {
			empRepo.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			
		}
	}
}















