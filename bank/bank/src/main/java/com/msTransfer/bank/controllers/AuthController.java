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
@CrossOrigin(origins = {"http://localhost:8080", "http://127.0.0.1:8080", "null","http://192.168.0.6:8081"},
methods = {org.springframework.web.bind.annotation.RequestMethod.POST,
           org.springframework.web.bind.annotation.RequestMethod.OPTIONS},
allowedHeaders = "*",
allowCredentials = "true")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtil jwtUtils;

	// Get User for name
	@PostMapping("/signin")
	public String authenticateUser(@RequestBody User user) {

		System.out.println("userdatos: " + user.getUsername() + " " + user.getPassword());
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		System.out.println("authentication" + authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		return jwtUtils.generateToken(userDetails.getUsername());
	}

	// Get User for name
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
