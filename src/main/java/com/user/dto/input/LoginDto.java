package com.user.dto.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LoginDto {
    private String username;
    private String password;
}
