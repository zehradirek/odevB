package com.tobeto.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.rack.SuccessResponseDTO;
import com.tobeto.dto.user.DeleteUserRequestDTO;
import com.tobeto.dto.user.UserRequestDTO;
import com.tobeto.dto.user.UserResponseDTO;
import com.tobeto.entity.User;
import com.tobeto.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;

	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	@GetMapping("/")
	public List<UserResponseDTO> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return users.stream().map(u -> responseMapper.map(u, UserResponseDTO.class)).toList();
	}

	@PostMapping("/create")
	public SuccessResponseDTO createUser(@RequestBody UserRequestDTO dto) {
		User user = requestMapper.map(dto, User.class);
		userService.saveUser(user);
		return new SuccessResponseDTO();
	}

	@PostMapping("/delete")
	public SuccessResponseDTO deleteUser(@RequestBody DeleteUserRequestDTO dto) {
		userService.deleteUser(dto.getUsername(), dto.getPassword());
		return new SuccessResponseDTO();
	}

	// @PostMapping("/update")
	// public SuccessResponseDTO updateUser(@RequestBody UpdateUserRequestDTO dto) {
	// userService.updateUser(dto.getEmail());
	// new SuccessResponseDTO();
	// }

}
