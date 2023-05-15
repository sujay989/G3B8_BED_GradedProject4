package com.greatlearning.empmgmt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.empmgmt.entity.Employee;
import com.greatlearning.empmgmt.service.EmployeeService;

@RestController
public class EmployeeRESTController {

	private EmployeeService employeeService;

	public EmployeeRESTController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/api/employees")
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/api/employees/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping("/api/addemployees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@PutMapping("/api/updateemployees")
	public String updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return "Updated Record Successfully";
	}

	@DeleteMapping("/api/employees/{id}")
	public String deleteEmployeeByID(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "Deleted employee id - " + id;
	}

	@GetMapping("/api/employees/search/{keyword}")
	public List<Employee> searchEmployeeByFirstName(Employee employee, @PathVariable String keyword) {
		return employeeService.searchEmployeeByFirstName(keyword);
	}

	@GetMapping("/api/employees/sort")
	public List<Employee> sortEmployeeByFirstName(@RequestParam String order) {
		List<Employee> sortedEmployee = new ArrayList();
		if (order.equals("asc"))
			sortedEmployee = employeeService.sortEmployeeFirstNameByAscending(order);
		else
			sortedEmployee = employeeService.sortEmployeeFirstNameByDescending(order);

		return sortedEmployee;
	}
}
