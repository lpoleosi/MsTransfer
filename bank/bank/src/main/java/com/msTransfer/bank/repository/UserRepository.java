package com.msTransfer.bank.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msTransfer.bank.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsernameIgnoreCase(String username);
    User findByUsername(String username);
    boolean existsByUsername(String username);
}