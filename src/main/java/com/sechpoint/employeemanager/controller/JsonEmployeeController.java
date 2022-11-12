package com.sechpoint.employeemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sechpoint.employeemanager.model.Employee;
import com.sechpoint.employeemanager.repository.EmployeeRepository;
import com.sechpoint.employeemanager.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class JsonEmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@PostMapping("/assignment_1")
	public List<Employee> assignment1(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return getEmployees();
	}

	@DeleteMapping("/assignment_2")
	public List<Employee> assignment2(@RequestParam Integer id) {
		employeeService.deleteEmployeeById(id);
		return getEmployees();
	}

	@GetMapping("/assignment_3")
	public List<Integer> assignment3() {
		return employeeRepository.assignment3();
	}

	@GetMapping("/assignment_4")
	public List<Integer> assignment4() {
		return employeeRepository.assignment4();
	}

	@GetMapping("/assignment_5")
	public List<Integer> assignment5(@RequestParam String department) {
		return employeeRepository.assignment5(department);
	}

	@GetMapping("/assignment_6")
	public List<Integer> assignment6(@RequestParam String department, @RequestParam String subDepartment) {
		return employeeRepository.assignment6(department, subDepartment);
	}
}
