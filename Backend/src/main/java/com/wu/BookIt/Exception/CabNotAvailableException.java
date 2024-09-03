package com.wu.BookIt.Exception;

public class CabNotAvailableException extends RuntimeException {
	public CabNotAvailableException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public String toString() {
		return super.getMessage();
	}
}
