package com.greatlearning.empmgmt.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.greatlearning.empmgmt.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee saveEmployee(Employee employee);

	public Employee getEmployeeById(Long id);

	public Employee updateEmployee(Employee employee);

	public void deleteEmployeeById(Long id);

	public List<Employee> searchEmployeeByFirstName(String keyword);

	public List<Employee> sortEmployeeFirstNameByAscending(String order);

	public List<Employee> sortEmployeeFirstNameByDescending(String order);
}
