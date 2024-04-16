package com.user.config;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Config {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "appLogger")
    public Logger logger() {
        return LoggerFactory.getLogger("AppLogger");
    }
}
