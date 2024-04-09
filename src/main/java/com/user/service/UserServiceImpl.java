package com.user.service;

import com.user.dao.Role;
import com.user.dao.User;
import com.user.dao.UserDao;
import com.user.dto.RoleDto;
import com.user.dto.UserRegistrationDto;
import com.user.service.api.RoleService;
import com.user.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    private PasswordEncoder passwordEncoder;

    private RoleService roleService;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public User create(UserRegistrationDto dto) {

        Role role = roleService.create(RoleDto.builder().id(UUID.randomUUID()).role("user").build());
        User user  = userDao.save(User
                .builder()
                .id(UUID.randomUUID())
                .name(dto.getName())
                .surname(dto.getSurname())
                .dateOfBirth(dto.getDateOfBirth())
                .password(passwordEncoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .role(role)
                .build());
        return user;
    }

    @Override
    public List<User> read() {
        return null;
    }

    @Override
    public User updateWithEntity(UUID id, User user) {
        return userDao.save(user);
    }

    @Override
    public User update(UUID id,UserRegistrationDto userRegistrationDto ) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {
        User user = userDao.findById(uuid).orElseThrow();
        userDao.delete(user);

    }

    @Override
    public User readById(UUID id) {
        return userDao.findById(id).orElseThrow();
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByEmail(username);
    }
}



