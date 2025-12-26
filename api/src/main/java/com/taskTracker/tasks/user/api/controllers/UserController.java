package com.taskTracker.tasks.user.api.controllers;

import com.taskTracker.tasks.core.exceptions.BusinessException;
import com.taskTracker.tasks.core.response.ApiResponse;
import com.taskTracker.tasks.user.api.requests.ChangePasswordRequest;
import com.taskTracker.tasks.user.api.requests.ProfileUpdateRequest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserController {
    public ResponseEntity<ApiResponse> updateUserProfile(ProfileUpdateRequest request, UUID userId) throws BusinessException, Exception;
    public ResponseEntity<ApiResponse> changePassword(ChangePasswordRequest request, UUID userId);
    public ResponseEntity<ApiResponse> deactivateAccount(UUID userId);
    public ResponseEntity<ApiResponse> deleteAccount(UUID userId);
    public ResponseEntity<ApiResponse> getUser(UUID userId);
}
