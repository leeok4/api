package com.leonardo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.model.Employee;
import com.leonardo.repository.EmployeeRepository;

@RestController
@RequestMapping("/reports")
public class ReportsController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees/age")
	public HashMap<String, Employee> getYoungerAndOlder() {
		List<Employee> empList = employeeRepository.findByOrderByBirthDate();
		
		Employee emp = new Employee();
		empList.get(0);
		
		HashMap<String, Employee> empJson = new HashMap<String, Employee>();
		
		empJson.put("younger", empList.get(empList.size()-1));
		empJson.put("older", empList.get(0));

		return empJson;
		
	}
	
	@GetMapping("/employees/salary")
	public HashMap<String, Employee> getLowestAndHighestSalary(){
		List<Employee> empList = employeeRepository.findByOrderBySalary();
		
		Employee emp = new Employee();
		empList.get(0);
		
		HashMap<String, Employee> empJson = new HashMap<String, Employee>();
		
		empJson.put("highest", empList.get(empList.size()-1));
		empJson.put("lowest", empList.get(0));
		
		return empJson;
	}
}
