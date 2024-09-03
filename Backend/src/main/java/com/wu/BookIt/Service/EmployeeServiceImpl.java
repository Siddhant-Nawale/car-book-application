package com.wu.BookIt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wu.BookIt.Exception.EmployeeNotFoundException;
import com.wu.BookIt.Repo.EmployeeRepo;
import com.wu.BookIt.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee employee1 = employeeRepo.save(employee);
		return employee1;
	}

	@Override
	public Employee getEmployeeWithEmployeeId(int id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Now Found"));
		return employee;
	}

}
