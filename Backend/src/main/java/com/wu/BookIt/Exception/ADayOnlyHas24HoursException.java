package com.wu.BookIt.Exception;

public class ADayOnlyHas24HoursException extends RuntimeException {
	public ADayOnlyHas24HoursException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public String toString() {
		return super.getMessage();
	}
}
