package com.msTransfer.bank.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.msTransfer.bank.entities.Cliente;
import com.msTransfer.bank.entities.CuentaBancaria;
import com.msTransfer.bank.repository.ClienteRepository;
import com.msTransfer.bank.repository.CuentaBancariaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CuentaBancariaService {

	@Autowired
	private CuentaBancariaRepository cuentaBancariaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	// Métodos para crear, actualizar, eliminar y buscar cuentas bancarias
	public CuentaBancaria crearCuenta(CuentaBancaria cuenta) {
		return cuentaBancariaRepository.save(cuenta);
	}

	// Métodos para crear validado cliente
	public CuentaBancaria createAccount(CuentaBancaria request) {
			
			// Buscar cliente por ID
			Cliente cliente = clienteRepository.findById(request.getCliente().getId())
					.orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

			// Crear cuenta
			CuentaBancaria account = new CuentaBancaria();
			LocalDateTime today = LocalDateTime.now();
			account = request;
			account.setFechaCreacion(today);
			account.setCliente(cliente);
			return  cuentaBancariaRepository.save(account);
	}

}
