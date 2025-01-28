package com.msTransfer.bank.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.msTransfer.bank.entities.CuentaBancaria;

@Repository
public class CuentaBancariaJpaRepository implements CuentaBancariaRepository {

	@Override
	public <S extends CuentaBancaria> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CuentaBancaria> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CuentaBancaria> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<CuentaBancaria> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CuentaBancaria> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CuentaBancaria entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends CuentaBancaria> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

    // ... JPA methods to interact with the database

}