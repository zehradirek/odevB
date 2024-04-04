package com.tobeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tobeto.entity.User;
import com.tobeto.repository.RoleRepository;
import com.tobeto.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;

	@Transactional
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Transactional
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Transactional
	public void updateUser(User user) {
		userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Transactional
	public boolean updatePassword(String username, String oldPassword, String newPassword) {
		Optional<User> oUser = userRepository.findByUsername(username);
		if (oUser.isPresent()) {
			User user = oUser.get();
			if (passwordEncoder.matches(oldPassword, user.getPassword())) {
				user.setPassword(passwordEncoder.encode(newPassword));
				userRepository.save(user);
				return true;
			}
		}
		return false;
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}

	public User newUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
