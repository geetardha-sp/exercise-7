package com.sechpoint.employeemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sechpoint.employeemanager.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "SELECT salary FROM employees", nativeQuery = true)
	List<Integer> assignment3();

	@Query(value = "SELECT salary FROM employees WHERE on_contract = TRUE", nativeQuery = true)
	List<Integer> assignment4();

	@Query(value = "SELECT salary FROM employees WHERE department = :department", nativeQuery = true)
	List<Integer> assignment5(String department);

	@Query(value = "SELECT salary FROM employees "
			+ "WHERE department = :department AND sub_department = :subDepartment", nativeQuery = true)
	List<Integer> assignment6(String department, String subDepartment);
}
