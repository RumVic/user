package com.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private final CustomUserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login/guestPage", "/login/in", "/register")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login/in")
                        .loginProcessingUrl("/login")
                        .failureUrl("/login/guestPage?error=true")
                        .defaultSuccessUrl("/homepage", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/login/out")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .clearAuthentication(true)
                        .logoutSuccessUrl("/login/guestPage")
                        .permitAll())
                .userDetailsService(userDetailsService);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            CustomUserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        /**
         * DaoAuthenticationProvider it is implementation
         * AuthenticationProvider, which use UserDetailsService
         *  for getting user's data and PasswordEncoder for checking passwords
         */
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        /**
         * This line configure authenticationProvider
         * by userDetailsService which control retreving user's data form db
         */
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        /**
         *  AuthenticationManager: instance of ProviderManager return bean,
         *  which will  use Spring Security for managing authentification process
         */
        return new ProviderManager(authenticationProvider);
    }

}
