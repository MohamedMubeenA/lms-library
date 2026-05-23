package com.lms.library_system.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.lms.library_system.response.ApiResponse;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse> handleValidationException(MethodArgumentNotValidException ex) {
		ApiResponse apiResponse = new ApiResponse();
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		apiResponse.setStatus(400);
		apiResponse.setMessage("Validation Failed");
		return ResponseEntity.badRequest().body(apiResponse);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiResponse> handleConstraintViolationException(ConstraintViolationException ex) {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStatus(400);
		apiResponse.setMessage(ex.getConstraintViolations().iterator().next().getMessage());
		return ResponseEntity.badRequest().body(apiResponse);
	}
}
