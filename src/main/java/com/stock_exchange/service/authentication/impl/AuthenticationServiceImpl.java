package com.stock_exchange.service.authentication.impl;

import com.stock_exchange.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    public void authenticate(String username, String password) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
