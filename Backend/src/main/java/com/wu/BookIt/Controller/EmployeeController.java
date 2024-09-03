package com.wu.BookIt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wu.BookIt.Service.EmployeeService;
import com.wu.BookIt.entity.Employee;

@RestController
@RequestMapping("employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping()
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		Employee employee1 = employeeService.createEmployee(employee);
		return ResponseEntity.ok().body(employee1);
	}
	
	@GetMapping()
	public ResponseEntity<Employee> getEmployeeWithEmployeeId(@RequestParam int id){
		Employee employee1 = employeeService.getEmployeeWithEmployeeId(id);
		return ResponseEntity.ok().body(employee1);
	}
}
