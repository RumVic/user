package com.user.dto.output;

import com.user.dao.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private UUID id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private Role role;
}
