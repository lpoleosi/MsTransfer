package com.msTransfer.bank.services;

import com.msTransfer.bank.entities.User;
import com.msTransfer.bank.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.info("username to validate : {}", username);
		//Boolean s = userRepository.existsByUsername(username);
		//logger.info("exist : {}", s);
		Optional<User> userOptional = userRepository.findByUsernameIgnoreCase(username);
		if (userOptional.isPresent()) {
			logger.debug("User Detail: {}", userOptional);
			User user = userOptional.get();
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					Collections.emptyList());
		} else {
			throw new UsernameNotFoundException("User not found");
		}

	}
}
