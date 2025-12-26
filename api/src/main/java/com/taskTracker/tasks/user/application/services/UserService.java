package com.taskTracker.tasks.user.application.services;

import com.taskTracker.tasks.core.exceptions.BusinessException;
import com.taskTracker.tasks.user.api.dtos.UserDTO;
import com.taskTracker.tasks.user.api.requests.ChangePasswordRequest;
import com.taskTracker.tasks.user.api.requests.ProfileUpdateRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface UserService extends UserDetailsService {

    void updateProfileInfo(ProfileUpdateRequest request, UUID userId) throws BusinessException;

    void changePassword(ChangePasswordRequest request, UUID userId) throws BusinessException;

    void deactivateAccount(UUID userId);

    void reactivateAccount(UUID userId);

    void deleteAccount(UUID userId);

    UserDTO getUserById(UUID userId);
}
