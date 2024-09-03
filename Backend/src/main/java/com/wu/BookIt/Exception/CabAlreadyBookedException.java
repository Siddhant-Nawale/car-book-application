package com.wu.BookIt.Exception;

public class CabAlreadyBookedException extends RuntimeException {
	public CabAlreadyBookedException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public String toString() {
		return super.getMessage();
	}
}
