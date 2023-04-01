package com.dev.agripocket.service.impl;
import com.dev.agripocket.model.AuthLogin;
import com.dev.agripocket.service.AuthLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthServiceLoginImpl implements AuthLoginService {
    @Autowired
    private AuthLogin authLogin;
    private AuthenticationManager authenticationManager;

    public AuthServiceLoginImpl(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }
    @Override
    public String login(AuthLogin authlogin) {
        Authentication authentication  = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authlogin.getUsernameOrEmail(),
                        authlogin.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "User logged-in successfully!";
    }
}
