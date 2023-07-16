package com.example.taskmanager.config;

import com.example.taskmanager.entity.User;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration

public class JpaAuditingConfig {
    @Bean
    public AuditorAware<User> userAuditorAware() {


        return new AuditorAware<User>() {
            @Override
            public Optional<User> getCurrentAuditor() {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if (authentication != null && authentication.getPrincipal() instanceof User) {
                    return Optional.of((User) authentication.getPrincipal());
                }
                return Optional.empty();
            }
        };
    }
}