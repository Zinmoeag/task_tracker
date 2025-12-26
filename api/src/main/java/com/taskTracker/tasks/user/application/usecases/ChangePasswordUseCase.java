package com.taskTracker.tasks.user.application.usecases;

import com.taskTracker.tasks.user.api.requests.ChangePasswordRequest;
import com.taskTracker.tasks.user.application.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ChangePasswordUseCase {

    private final UserService userService;
    
    public void execute(ChangePasswordRequest request, UUID userId) {
        this.userService.changePassword(request, userId);
    }
}

