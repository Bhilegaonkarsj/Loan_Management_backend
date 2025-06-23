package com.example.utils;

import java.io.UnsupportedEncodingException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.LoginDataResponseModel;
import com.google.gson.Gson;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.http.HttpServletResponse;


@Service
public class CommonUtils {

	
	
	
	public ResponseEntity<GeneralResponse> jwtCheckProduct(String token) {
		LoginDataResponseModel authenticateUserResponse = null;
		try {
			Integer validationFlag = Integer.valueOf(1);
			if (validationFlag == 1) {
//				DashboardConfigurationEntity dashboardConfigurationEntity = dashboardConfigurationJpaRepository
//						.findByDashboardConfigurationId(25L);
				String jwtData = JwtUtil.parseJWT(token);
				authenticateUserResponse = new Gson().fromJson(jwtData, LoginDataResponseModel.class);
//				int expiresIn = 0;
//				if (dashboardConfigurationEntity != null) {
//					expiresIn = Integer.parseInt(dashboardConfigurationEntity.getDashVal());
//				}
				// token = JwtUtil.createJWTToken(new Gson().toJson(authenticateUserResponse),
				// expiresIn);
				authenticateUserResponse.setToken(token);
			} else {
				authenticateUserResponse = new LoginDataResponseModel();
			}
			return new ResponseEntity<GeneralResponse>(
					new GeneralResponse(HttpServletResponse.SC_OK, null, authenticateUserResponse, token),
					HttpStatus.OK);
		} catch (ExpiredJwtException e2) {
			return new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_UNAUTHORIZED,
					Constants.ERROR_INVAILD_TOKEN_1, authenticateUserResponse, null), HttpStatus.OK);
		} catch (UnsupportedJwtException e2) {
			return new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_UNAUTHORIZED,
					Constants.ERROR_INVAILD_TOKEN_1, authenticateUserResponse, null), HttpStatus.OK);
		} catch (MalformedJwtException e2) {
			return new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_UNAUTHORIZED,
					Constants.ERROR_INVAILD_TOKEN_1, authenticateUserResponse, null), HttpStatus.OK);
		} catch (SignatureException e2) {
			return new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_UNAUTHORIZED,
					Constants.ERROR_INVAILD_TOKEN_1, authenticateUserResponse, null), HttpStatus.OK);
		} catch (IllegalArgumentException e2) {
			return new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_UNAUTHORIZED,
					Constants.ERROR_INVAILD_TOKEN_1, authenticateUserResponse, null), HttpStatus.OK);
		} catch (UnsupportedEncodingException e) {
			return new ResponseEntity<GeneralResponse>(new GeneralResponse(HttpServletResponse.SC_UNAUTHORIZED,
					Constants.ERROR_INVAILD_TOKEN_1, authenticateUserResponse, null), HttpStatus.OK);
		}

}
}
