package com.wu.BookIt.Exception;

public class PlaceNotAvailableException extends RuntimeException {
	public PlaceNotAvailableException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public String toString() {
		return super.getMessage();
	}
}
