package com.lms.library_system.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

@Component
public class JwtUtil {

	private final String SECRET_KEY = "mysecuresecretkeymysecuresecretkey1234567890";

	public String generateToken(String username) {

		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact(); //for final String token generation
	}
	
	public String extractUserName(String token) {
		return extractClaims(token).getSubject();  //subject - userName
	}

	private Claims extractClaims(String token) { //Claim - usrname,expiry,issue-time	
		return Jwts.parser()
				.setSigningKey(SECRET_KEY)
			    .parseClaimsJws(token) //token validate + decode
			    .getBody();
	}
	public boolean validateToken(String token, String userName) {
		String extractedUserName = extractUserName(userName);
		return extractedUserName.equals(userName);
	}

}




