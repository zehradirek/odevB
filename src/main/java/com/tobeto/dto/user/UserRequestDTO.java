package com.tobeto.dto.user;

import com.tobeto.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private UUID id;
    private String userName;
    private String email;
    private String password;
    private Role role;
}

