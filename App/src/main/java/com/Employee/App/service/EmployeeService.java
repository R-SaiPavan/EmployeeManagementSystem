package com.Employee.App.service;

import java.util.List;

import com.Employee.App.model.Employee;

public interface EmployeeService {
	 List<Employee> getAllEmployees();
	 void saveEmployee(Employee employee);
	 Employee getEmployeeById(Long id);
	 void deleteEmployeeById(Long id);
	 void saveSignUp(Employee employee);
	Employee employee(String email, String password);
	
}
