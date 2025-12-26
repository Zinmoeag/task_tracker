package com.taskTracker.tasks.user.application.usecases;

import com.taskTracker.tasks.user.application.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class DeactivateAccountUseCase {

    private final UserService userService;

    public void execute(UUID userId) {
        this.userService.deactivateAccount(userId);
    }
}

