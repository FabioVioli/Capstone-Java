package com.Capstone.auth.service;

import com.Capstone.auth.payload.LoginDto;
import com.Capstone.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
