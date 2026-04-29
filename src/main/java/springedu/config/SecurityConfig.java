package com.springedu.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager
    users(PasswordEncoder encoder) {

        UserDetails admin =
            User.builder()

            .username("admin")

            .password(
                encoder.encode("1234")
            )

            .roles("ADMIN")
            .build();

        UserDetails user =
            User.builder()

            .username("user")

            .password(
                encoder.encode("1234")
            )

            .roles("USER")
            .build();

        return new
            InMemoryUserDetailsManager(
                admin,
                user
            );
    }

    @Bean
    public SecurityFilterChain
    filterChain(HttpSecurity http)
    throws Exception {

        http

        .authorizeHttpRequests(auth -> auth

            .requestMatchers(
                "/css/**",
                "/js/**"
            ).permitAll()

            .requestMatchers(
                "/cursos/nuevo"
            ).hasRole("ADMIN")

            .anyRequest()
            .authenticated()
        )

        .formLogin(login -> login

            .loginPage("/login")

            .permitAll()
        )

        .logout(logout -> logout

            .permitAll()
        );

        return http.build();
    }
}
