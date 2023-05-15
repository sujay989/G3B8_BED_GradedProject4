package com.greatlearning.empmgmt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greatlearning.empmgmt.entity.Employee;
import com.greatlearning.empmgmt.repository.EmployeeRepository;
import com.greatlearning.empmgmt.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> searchEmployeeByFirstName(String keyword) {
		return employeeRepository.findByEmployeesFirstName(keyword);
	}

	@Override
	public List<Employee> sortEmployeeFirstNameByAscending(String order) {
		return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
	}

	@Override
	public List<Employee> sortEmployeeFirstNameByDescending(String order) {
		return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
	}

}
