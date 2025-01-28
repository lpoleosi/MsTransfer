package com.msTransfer.bank.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(JwtUtil.class)
class JwtUtilTest {

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    public void generateToken_shouldGenerateValidToken() {
        String username = "testuser";
        String token = jwtUtil.generateToken(username);
        System.out.println(token);
        // Verifica el token utilizando un decodificador JWT en línea
        // o implementando tu propia lógica de validación
        // ...
    }
}