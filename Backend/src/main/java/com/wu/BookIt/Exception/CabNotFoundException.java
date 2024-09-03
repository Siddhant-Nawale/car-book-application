package com.wu.BookIt.Exception;

public class CabNotFoundException extends RuntimeException {
	public CabNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public String toString() {
		return super.getMessage();
	}
}
