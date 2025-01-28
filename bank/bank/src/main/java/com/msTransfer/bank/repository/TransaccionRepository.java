package com.msTransfer.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.msTransfer.bank.entities.Transaccion;

public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {

}
