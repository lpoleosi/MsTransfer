package com.msTransfer.bank.controllers;

import com.msTransfer.bank.entities.User;
import com.msTransfer.bank.repository.UserRepository;
import com.msTransfer.bank.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtil jwtUtils;

	@PostMapping("/signin")
	public String authenticateUser(@RequestBody User user) {

		System.out.println("userdatos: " + user.getUsername() + " " + user.getPassword());
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		System.out.println("authentication" + authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		return jwtUtils.generateToken(userDetails.getUsername());
	}

	@PostMapping("/signup")
	public String registerUser(@RequestBody User user) {
		if (userRepository.existsByUsername(user.getUsername())) {
			return "Error: Username is already taken!";
		}
		User newUser = new User();
		newUser = user;
		newUser.setPassword(encoder.encode(user.getPassword()));
		// Create new user's account
//        User newUser = new User(
//                null,
//                user.getUsername(),
//                encoder.encode(user.getPassword())
//        );
        userRepository.save(newUser);
		return "Usuario Registrado para Token!";
	}
}
