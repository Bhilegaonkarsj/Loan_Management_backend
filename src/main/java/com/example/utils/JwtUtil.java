package com.example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;


//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	
	private static String key = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";

	public static String createJWTToken(String data, int min) {
	    Calendar c = Calendar.getInstance();
	    c.add(Calendar.MINUTE, min);
	    Date expirationDate = c.getTime();

	    // Generate or load a secure key
	    SecretKey key = Keys.hmacShaKeyFor("your-256-bit-secret-goes-here-should-be-32-bytes!".getBytes());

	    String jwt = Jwts.builder()
	            .setSubject("pfm/AuthServices")
	            .setExpiration(expirationDate)
	            .claim("name", "TokenData")
	            .claim("scope", "customer/payments")
	            .claim("data", data)
	            .signWith(key, SignatureAlgorithm.HS256) // updated signature method
	            .compact();

	    System.out.println(jwt);
	    return jwt;
	}
	
	
	
	public static String parseJWT(String jwt) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException{
		Jws<Claims> claims = Jwts.parser()
				.setSigningKey(key.getBytes("UTF-8"))
				.parseClaimsJws(jwt);
		String name = (String) claims.getBody().get("name");
		String scope = (String) claims.getBody().get("scope");
		String data = (String) claims.getBody().get("data");
		
//                        System.out.println("claims is:"+claims);
//						System.out.println("name is:"+name);	
//						System.out.println("scope is:"+scope);
//						System.out.println("data is"+data);
		return data;
	}


}
