package com.user.mapper.implementation;

import com.user.config.Config;
import com.user.dao.entity.User;
import com.user.dto.output.UserDto;
import com.user.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    private final Config config;

    @Autowired
    public UserMapperImpl(Config config) {
        this.config = config;
    }

    @Override
    public UserDto entityToDTO(User user) {
        ModelMapper modelMapper = config.modelMapper();
        return modelMapper.map(user, UserDto.class);
    }
}
