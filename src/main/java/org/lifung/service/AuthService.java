package org.lifung.service;

import org.lifung.payload.LoginDto;
import org.lifung.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
