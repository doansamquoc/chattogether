package com.sam.chattogether.services;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.sam.chattogether.dtos.requests.AuthRequest;
import com.sam.chattogether.dtos.responses.AuthResponse;
import com.sam.chattogether.utils.JwtUtil;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public AuthService(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
            UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    public ResponseEntity<AuthResponse> login(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(), authRequest.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String accessToken = jwtUtil.generateAccessToken(userDetails);
        String refreshToken = jwtUtil.generateRefreshToken(userDetails);

        AuthResponse authResponse = new AuthResponse(accessToken, refreshToken);

        return ResponseEntity.ok(authResponse);
    }
}
