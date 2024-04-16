package com.user.service;

import com.user.dao.entity.User;
import com.user.dto.input.UserRegistrationDto;
import com.user.dto.output.UserDto;

public interface UserService extends Service<User, UserRegistrationDto, UserDto>{

    User findByUsername(String username);
}
