package com.msTransfer.bank.repository;

import org.springframework.data.repository.CrudRepository;


import com.msTransfer.bank.entities.CuentaBancaria;
public interface CuentaBancariaRepository extends CrudRepository<CuentaBancaria, Long> {
}