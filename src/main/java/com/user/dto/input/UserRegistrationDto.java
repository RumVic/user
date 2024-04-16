package com.user.dto.input;

import com.user.dao.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegistrationDto {

    private UUID id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private Role role;
}
