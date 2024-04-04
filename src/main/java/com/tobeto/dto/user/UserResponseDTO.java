package com.tobeto.dto.user;

import java.util.UUID;

import com.tobeto.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
	private UUID id;
	private String username;
	private Role role;

}