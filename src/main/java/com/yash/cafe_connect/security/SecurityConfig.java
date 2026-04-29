package com.yash.cafe_connect.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // ❌ Disable CSRF (needed for Postman / APIs)
                .csrf(csrf -> csrf.disable())

                // ✅ Allow all requests (no authentication required)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )

                // ❌ Disable default login page
                .formLogin(form -> form.disable())

                // ❌ Disable basic auth popup
                .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }
}