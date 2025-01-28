package com.msTransfer.bank.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msTransfer.bank.controllers.CuentaBancariaController;
import com.msTransfer.bank.entities.Cliente;
import com.msTransfer.bank.entities.CuentaBancaria;
import com.msTransfer.bank.security.AuthTokenFilter;
import com.msTransfer.bank.security.JwtUtil;
import com.msTransfer.bank.services.CuentaBancariaService;
import com.msTransfer.bank.services.CustomUserDetailsService;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@WebMvcTest(CuentaBancariaController.class)
class CuentaBancariaControllerTest {
		@Autowired
	    private MockMvc mockMvc;
		
		@Autowired
		private JwtUtil jwtUtil;
		
	    @MockBean
	    private CuentaBancariaService cuentaBancariaService;

	    @Autowired
	    private ObjectMapper objectMapper;
	    
	    @Test
	    @WithMockUser(roles = "USER")
	    void crearCuenta_shouldReturnCreated() throws Exception {
	        String token = jwtUtil.generateToken("lpoleos");
	        System.out.println(token);
	       	CuentaBancaria cuenta = new CuentaBancaria();
	        cuenta.setTipoCuenta("CORRIENTE");
	        cuenta.setSaldo(new BigDecimal("1000"));
	      
	        Cliente cliente = new Cliente();
	        cliente.setId(Long.valueOf(1));
	        cliente.setNombre("test");
	        cliente.setApellido("test");
	        cuenta.setCliente(cliente);

	        when(cuentaBancariaService.crearCuenta(any())).thenReturn(cuenta);
	        RequestBuilder request = MockMvcRequestBuilders.post("/api/cuentas")
	        		 .header("Authorization", "Bearer " + token)
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(cuenta));
	        mockMvc.perform(request)
            .andExpect(status().isCreated());
	    }

	   	    
}