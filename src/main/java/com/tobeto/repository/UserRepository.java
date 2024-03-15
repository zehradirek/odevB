package com.tobeto.repository;

import com.tobeto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUserName(String name);

   Optional<User> findByEmail(String email);
}
