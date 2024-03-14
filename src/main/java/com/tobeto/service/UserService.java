package com.tobeto.service;

import com.tobeto.entity.User;
import com.tobeto.repository.RoleRepository;
import com.tobeto.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public Optional<User> getUserByName(String name) {
        return userRepository.findByUserName(name);
    }

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

    @Transactional
    public boolean updatePassword(UUID userId, String oldPassword, String newPassword) {
        Optional<User> optionalUser = userRepository.findById(userId);

        return optionalUser.map(user -> {
            if (passwordEncoder.matches(oldPassword, user.getPassword())) {
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
                return true;
            } else {
                return false; // Eski şifre doğru değilse
            }
        }).orElse(false); // Employee bulunamadıysa
    }

    @Transactional
    public void updateRole(User user) {
        User optionalUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        optionalUser.setRole(user.getRole());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUserById(UUID userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public Optional<User> getUseById(UUID userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User signUp(String email, String password) {
        checkIfEmailExists(email);
        User users = new User();
        users.setEmail(email);
        users.setPassword(passwordEncoder.encode(password));
        return userRepository.save(users);
    }

    private void checkIfEmailExists(String email) {
        if (userRepository.findByUserName(email).isPresent()) {
            throw new RuntimeException("Already email exists!");
        }
    }
}

