package com.tobeto.dto.user;

import com.tobeto.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private UUID id;
    private String userName;
    private Role role;

}