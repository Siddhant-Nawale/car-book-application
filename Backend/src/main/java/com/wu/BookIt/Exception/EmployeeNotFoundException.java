package com.wu.BookIt.Exception;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public String toString() {
		return super.getMessage();
	}
}
