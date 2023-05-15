package com.greatlearning.empmgmt.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.empmgmt.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "select * from employee where first_name like %?1%", nativeQuery = true)
	List<Employee> findByEmployeesFirstName(String keyword);

}
