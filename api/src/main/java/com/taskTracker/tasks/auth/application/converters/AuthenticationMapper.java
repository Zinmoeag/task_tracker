package com.taskTracker.tasks.auth.application.converters;

import com.taskTracker.tasks.auth.api.requests.RegistrationRequest;
import com.taskTracker.tasks.user.entities.RoleEntity;
import com.taskTracker.tasks.user.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthenticationMapper {

    private final PasswordEncoder passwordEncoder;

    public UserEntity toEntity(RegistrationRequest request, List<RoleEntity> roles) {
        return UserEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(this.passwordEncoder.encode(request.getPassword()))
                .dateOfBirth(request.getDateOfBirth())
                .roles(roles)
                .enabled(true)
                .locked(false)
                .credentialsExpired(false)
                .emailVerified(false)
                .phoneVerified(false)
                .build();
    }
}

