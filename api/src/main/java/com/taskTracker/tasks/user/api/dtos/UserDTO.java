package com.taskTracker.tasks.user.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private boolean enabled;
    private boolean locked;
    private boolean credentialsExpired;
    private boolean emailVerified;
    private String profilePictureUrl;
    private boolean phoneVerified;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}

