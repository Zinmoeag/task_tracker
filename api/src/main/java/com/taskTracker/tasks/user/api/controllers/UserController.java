package com.taskTracker.tasks.user.api.controllers;

import com.taskTracker.tasks.user.api.requests.ProfileUpdateRequest;

import java.util.UUID;

public interface UserController {
    public void updateUserProfile(ProfileUpdateRequest request, UUID userId);
}
