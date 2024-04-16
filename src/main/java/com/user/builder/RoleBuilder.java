package com.user.builder;

import com.user.dao.entity.Role;
import com.user.dto.input.RoleDto;
import lombok.Data;

import java.util.UUID;

@Data
public class RoleBuilder {
    private UUID id;
    private String role;

    public static Role builder(RoleDto roleDto) {
        return new Role(roleDto.getId(), roleDto.getRole());
    }
}
