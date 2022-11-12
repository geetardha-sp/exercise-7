package com.sechpoint.employeemanager.service;

import java.util.List;

import com.sechpoint.employeemanager.model.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();
	public void addEmployee(Employee employee);
	public Employee getEmployeeById(Integer id);
	public void deleteEmployeeById(Integer id);
}
