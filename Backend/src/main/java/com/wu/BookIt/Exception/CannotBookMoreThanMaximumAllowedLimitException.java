package com.wu.BookIt.Exception;

public class CannotBookMoreThanMaximumAllowedLimitException extends RuntimeException {
	public CannotBookMoreThanMaximumAllowedLimitException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public String toString() {
		return super.getMessage();
	}
}
