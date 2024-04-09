package com.user;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.user.dao.Role;
import com.user.dao.User;
import com.user.dao.UserDao;
import com.user.dto.RoleDto;
import com.user.dto.UserRegistrationDto;
import com.user.service.UserServiceImpl;
import com.user.service.api.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @Mock
    private RoleService roleService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void createUserTest() {
        UUID roleId = UUID.randomUUID();
        Role role = new Role(roleId, "user");
        UserRegistrationDto dto = new UserRegistrationDto("John", "Doe", LocalDate.of(1990, 1, 1),"john.doe@example.com", "password" );
        User expectedUser = new User(UUID.randomUUID(), "John", "Doe", LocalDate.of(1990, 1, 1), "john.doe@example.com", "encodedPassword", role);

        when(roleService.create(any(RoleDto.class))).thenReturn(role);
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userDao.save(any(User.class))).thenReturn(expectedUser);

        User resultUser = userService.create(dto);

        assertNotNull(resultUser);
        assertEquals("John", resultUser.getName());
        assertEquals("encodedPassword", resultUser.getPassword());
        verify(userDao, times(1)).save(any(User.class));
        verify(roleService, times(1)).create(any(RoleDto.class));
        verify(passwordEncoder, times(1)).encode("password");
    }
}
