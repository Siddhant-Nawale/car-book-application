package com.wu.BookIt.Exception;

public class SeatNotAvailableException extends RuntimeException {
	public SeatNotAvailableException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public String toString() {
		return super.getMessage();
	}
}
