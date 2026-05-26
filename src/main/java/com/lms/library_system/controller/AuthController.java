package com.lms.library_system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lms.library_system.dto.AuthRequest;
import com.lms.library_system.dto.AuthResponse;
import com.lms.library_system.security.JwtUtil;

@RestController
@RequestMapping("/v1/author")
public class AuthController {
	@Autowired
	private JwtUtil jwtUtil;

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
		AuthResponse authResponse = new AuthResponse();
		final String name = "admin";
		final String password = "admin123";
		String requestUserName = request.getUsername();
		String requestUserpwd = request.getPassword();
		if (name.equals(requestUserName) && password.equals(requestUserpwd)) {
		    String token = jwtUtil.generateToken(requestUserName);
		    authResponse.setStatus(201);
		    authResponse.setMessage("token created successfully");
		    authResponse.setToken(token);
		    return ResponseEntity.ok(authResponse);
		} else {
			logger.warn("Invalid user credentials");
			authResponse.setStatus(401);
		    authResponse.setMessage("Invalid user credentials");
		    return ResponseEntity.badRequest().body(authResponse);
		}
	}
}
