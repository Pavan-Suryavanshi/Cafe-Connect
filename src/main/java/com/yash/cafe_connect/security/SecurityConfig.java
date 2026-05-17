package com.yash.cafe_connect.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        // Public APIs
                        .requestMatchers("/auth/**").permitAll()

                        // ADMIN only
                        .requestMatchers("/thali/**").hasRole("ADMIN")

                        // USER + ADMIN
                        .requestMatchers("/token/**").hasAnyRole("USER", "ADMIN")

                        // USER + ADMIN
                        .requestMatchers("/feedback/**").hasAnyRole("USER", "ADMIN")

                        // Any logged-in user
                        .anyRequest().authenticated()
                )

                .addFilterBefore(
                        jwtFilter,
                        UsernamePasswordAuthenticationFilter.class
                )

                .formLogin(form -> form.disable())

                .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }
}