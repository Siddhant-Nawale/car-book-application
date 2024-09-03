package com.wu.BookIt.Exception;

public class InvalidTimeException extends RuntimeException {
	public InvalidTimeException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public String toString() {
		return super.getMessage();
	}
}
