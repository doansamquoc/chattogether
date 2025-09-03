package com.sam.chattogether.dtos.responses;

public class AuthResponse {
	String accessToken;
	String refreshToken;

	public AuthResponse(String accessToken, String refreshToken) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

}
