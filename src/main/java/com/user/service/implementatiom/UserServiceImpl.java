package com.user.service.implementatiom;

import com.user.builder.UserBuilder;
import com.user.dao.entity.Role;
import com.user.dao.entity.User;
import com.user.dao.repository.UserDao;
import com.user.dto.input.RoleDto;
import com.user.dto.input.UserRegistrationDto;
import com.user.dto.output.UserDto;
import com.user.mapper.UserMapper;
import com.user.service.RoleService;
import com.user.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    private final RoleService roleService;

    private final UserMapper userMapper;

    @Qualifier("appLogger")
    private final Logger logger;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder, RoleService roleService, UserMapper userMapper, Logger logger) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.userMapper = userMapper;
        this.logger = logger;
    }

    @Override
    public User create(UserRegistrationDto dto) {
        Role role = roleService.create(RoleDto.builder().id(UUID.randomUUID()).role("user").build());
        User user = UserBuilder.buildCreate(dto, role, passwordEncoder);
        return userDao.save(user);
    }

    @Override
    public void delete(UUID uuid) {
        User user = userDao.findById(uuid).orElseThrow(() ->
        {
            logger.error("user not found");
            return new ResponseStatusException(HttpStatus.BAD_REQUEST);
        });
        userDao.delete(user);
    }

    @Override
    public UserDto readById(UUID id) {
        return userMapper.entityToDTO(userDao.findById(id).orElseThrow(() ->
                        {
                            logger.error("user not found");
                            return new ResponseStatusException(HttpStatus.NO_CONTENT);
                        }
                )
        );
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByEmail(username);
    }

    @Override
    public User update(UUID id, UserRegistrationDto dto) {
        return userDao.save(UserBuilder.buildUpdate(dto, passwordEncoder));
    }

    @Override
    public List<User> read() {
        return null;
    }
}



