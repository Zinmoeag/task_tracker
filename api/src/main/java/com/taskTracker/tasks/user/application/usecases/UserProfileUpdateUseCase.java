package com.taskTracker.tasks.user.application.usecases;

import com.taskTracker.tasks.user.api.requests.ProfileUpdateRequest;
import com.taskTracker.tasks.user.application.services.UserService;
import com.taskTracker.tasks.user.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class UserProfileUpdateUseCase {

    private final UserService userService;
    public void execute(ProfileUpdateRequest request, UUID userId) {
        this.userService.updateProfileInfo(request, userId);
    };
}
