package com.taskTracker.tasks.user.api.controllers.impl;

import com.taskTracker.tasks.user.api.controllers.UserController;
import com.taskTracker.tasks.user.api.requests.ProfileUpdateRequest;
import com.taskTracker.tasks.user.application.services.UserService;
import com.taskTracker.tasks.user.application.usecases.UserProfileUpdateUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
public class UserControllerImpl implements UserController {
    private final UserProfileUpdateUseCase userProfileUpdateUseCase;

    @Override
    @PatchMapping("/me")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserProfile(@RequestBody @Valid ProfileUpdateRequest request, UUID userId) {
        System.out.println("hello mello");
        this.userProfileUpdateUseCase.execute(request, userId);
    }
}
