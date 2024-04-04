package com.tobeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.login.LoginRequestDTO;
import com.tobeto.dto.login.LoginResponseDTO;
import com.tobeto.entity.User;
import com.tobeto.service.TokenService;
import com.tobeto.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {
		User users = userService.getUserByEmail(dto.getEmail());
		if (dto.getPassword().equals(users.getPassword())) {
			String token = tokenService.createToken(users);
			return ResponseEntity.ok(new LoginResponseDTO(token));
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<LoginResponseDTO> signUp(@RequestBody LoginRequestDTO dto) {
		User users = userService.newUser(dto.getEmail(), dto.getPassword());
		String token = tokenService.createToken(users);
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}

}
