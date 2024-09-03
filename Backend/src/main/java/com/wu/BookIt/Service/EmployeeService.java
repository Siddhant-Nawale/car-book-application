package com.wu.BookIt.Service;

import com.wu.BookIt.entity.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
	public Employee getEmployeeWithEmployeeId(int id);
}
