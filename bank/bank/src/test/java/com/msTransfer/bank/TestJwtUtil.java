package com.msTransfer.bank;

import org.springframework.stereotype.Component;

@Component
public class TestJwtUtil {
    public String generateToken(String username) {
        // Return a dummy token for testing
        return "dummy-token";
    }
}
