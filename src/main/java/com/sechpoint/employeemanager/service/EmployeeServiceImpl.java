package com.sechpoint.employeemanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sechpoint.employeemanager.model.Employee;
import com.sechpoint.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		throw new RuntimeException("Employee not found with id: " + id);
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id);
	}
}
