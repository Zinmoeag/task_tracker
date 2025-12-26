package com.taskTracker.tasks.user.application.converters;

import com.taskTracker.tasks.user.api.dtos.UserDTO;
import com.taskTracker.tasks.user.api.requests.ProfileUpdateRequest;
import com.taskTracker.tasks.user.entities.UserEntity;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public void mergeUserInfo(final UserEntity user, final ProfileUpdateRequest request) {
        if (StringUtils.isNotBlank(request.getFirstName()) && !user.getFirstName()
                .equals(request.getFirstName())) {
            user.setFirstName(request.getFirstName());
        }
        if (StringUtils.isNotBlank(request.getLastName()) && !user.getLastName()
                .equals(request.getLastName())) {
            user.setLastName(request.getLastName());
        }
        if (request.getDateOfBirth() != null && !request.getDateOfBirth()
                .equals(user.getDateOfBirth())) {
            user.setDateOfBirth(request.getDateOfBirth());
        }
    }

    public UserDTO toDTO(final UserEntity user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .dateOfBirth(user.getDateOfBirth())
                .enabled(user.isEnabled())
                .locked(user.isLocked())
                .credentialsExpired(user.isCredentialsExpired())
                .emailVerified(user.isEmailVerified())
                .profilePictureUrl(user.getProfilePictureUrl())
                .phoneVerified(user.isPhoneVerified())
                .createdDate(user.getCreatedDate())
                .lastModifiedDate(user.getLastModifiedDate())
                .build();
    }
}
