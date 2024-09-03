package com.wu.BookIt.Exception;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> myExHandler(Exception ex) {
		String msg = ex.getMessage();
		return ResponseEntity.internalServerError().body(Map.of("message",msg));
	}
}
