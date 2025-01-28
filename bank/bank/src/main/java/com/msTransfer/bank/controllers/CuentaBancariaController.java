package com.msTransfer.bank.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.msTransfer.bank.entities.CuentaBancaria;
import com.msTransfer.bank.services.CuentaBancariaService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaBancariaController {
	 	@Autowired
	    private CuentaBancariaService cuentaBancariaService;
	 	
	 	 private static final Logger logger = LogManager.getLogger(CuentaBancariaController.class);

	 	 @PostMapping
	     public ResponseEntity<CuentaBancaria> crearCuenta(@RequestBody CuentaBancaria request) {
	         try {
	        	 logger.info("Creating new account: {}", request);
	        	 CuentaBancaria  cta = cuentaBancariaService.createAccount(request);
	             return new ResponseEntity<>(cta, HttpStatus.CREATED);
	         } catch (EntityNotFoundException e) {
	        	 logger.error("Error creating account: Client not found", e);
	        	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	         }
	     }
	    
	  
}
