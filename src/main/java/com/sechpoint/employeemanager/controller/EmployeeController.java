package com.sechpoint.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sechpoint.employeemanager.model.Employee;
import com.sechpoint.employeemanager.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("employees", employeeService.getEmployees());
		return "index";
	}

	@GetMapping("/add_employee")
	public String addEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "add_employee";
	}

	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.addEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/update_employee/{id}")
	public String updateEmployeeForm(@PathVariable(value = "id") Integer id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "update_employee";
	}

	@GetMapping("/delete_employee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Integer id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
