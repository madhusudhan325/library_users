package com.mindtree.librarydata.controller.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.librarydata.controller.LibraryUserAppController;
import com.mindtree.librarydata.exception.ServiceException;

@RestControllerAdvice(assignableTypes = LibraryUserAppController.class)
public class AppExceptionHandler {
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<Map<String, Object>> ServiceExceptionHandler(Exception e, Throwable cause) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "library users");
		response.put("Error", true);
		response.put("body", e.getMessage());
		response.put("Httpstatus", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	}
}
