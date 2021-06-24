package com.leonardo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.model.Employee;
import com.leonardo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeRepository.findById(id).get();
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeRepository.deleteById(id);
		return "Employee is deleted with id " + id;
	}

	@PutMapping("/")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

}
