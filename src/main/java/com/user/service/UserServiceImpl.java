package com.user.service;

import com.user.dao.User;
import com.user.dao.UserDao;
import com.user.dto.UserRegistrationDto;
import com.user.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User create(UserRegistrationDto dto) {
        return null;
    }

    @Override
    public List<User> read() {
        return null;
    }

    @Override
    public User update(UUID id, UserRegistrationDto dto) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public User readById(UUID id) {
        return null;
    }
}
