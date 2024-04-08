//package com.user.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//
//                .authorizeRequests((authorizeRequests) ->
//                authorizeRequests
//                        .requestMatchers("/**").hasRole("USER"))
//                .antMatchers("/register", "/css/**", "/js/**")
//                .permitAll() // Разрешить доступ к странице регистрации и статическим ресурсам
//                .anyRequest().authenticated() // Требовать аутентификацию для всех остальных запросов
//                .and()
//                .formLogin()
//                .loginPage("/login") // Указать кастомную страницу входа
//                .permitAll() // Разрешить доступ к форме входа всем
//                .and()
//                .logout()
//                .permitAll(); // Разрешить всем выходить из системы
//    }
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER"); // Пример конфигурации in-memory аутентификации
//    }
//}
//
//}
