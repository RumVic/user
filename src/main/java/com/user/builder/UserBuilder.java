package com.user.builder;

import com.user.dao.entity.Role;
import com.user.dao.entity.User;
import com.user.dto.input.UserRegistrationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBuilder {
    private UUID id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private Role role;


    public static User buildCreate(UserRegistrationDto dto, Role role, PasswordEncoder passwordEncoder) {
        return new User(UUID.randomUUID(),
                dto.getName(),
                dto.getSurname(),
                dto.getDateOfBirth(),
                dto.getEmail(),
                passwordEncoder.encode(dto.getPassword()),
                role
        );
    }

    public static User buildUpdate(UserRegistrationDto dto, PasswordEncoder passwordEncoder) {
        return new User(
                dto.getId(),
                dto.getName(),
                dto.getSurname(),
                dto.getDateOfBirth(),
                dto.getEmail(),
                passwordEncoder.encode(dto.getPassword()),
                dto.getRole()
        );
    }
}
