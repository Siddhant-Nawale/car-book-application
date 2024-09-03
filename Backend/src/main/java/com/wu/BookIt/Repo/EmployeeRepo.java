package com.wu.BookIt.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wu.BookIt.entity.Cab;
import com.wu.BookIt.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
