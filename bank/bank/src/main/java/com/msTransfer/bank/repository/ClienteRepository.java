package com.msTransfer.bank.repository;


import org.springframework.data.repository.CrudRepository;

import com.msTransfer.bank.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
