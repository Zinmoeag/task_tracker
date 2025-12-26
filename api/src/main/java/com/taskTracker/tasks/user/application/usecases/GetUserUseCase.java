package com.taskTracker.tasks.user.application.usecases;

import com.taskTracker.tasks.user.api.dtos.UserDTO;
import com.taskTracker.tasks.user.application.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class GetUserUseCase {

    private final UserService userService;

    public UserDTO execute(UUID userId) {
        return this.userService.getUserById(userId);
    }
}

