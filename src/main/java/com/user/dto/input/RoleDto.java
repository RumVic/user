package com.user.dto.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class RoleDto {
    private UUID id;
    private String role;
}
