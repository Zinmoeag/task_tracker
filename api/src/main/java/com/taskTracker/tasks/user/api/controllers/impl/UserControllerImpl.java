package com.taskTracker.tasks.user.api.controllers.impl;

import com.taskTracker.tasks.core.exceptions.BusinessException;
import com.taskTracker.tasks.core.exceptions.ErrorCode;
import com.taskTracker.tasks.core.response.ApiResponse;
import com.taskTracker.tasks.user.api.controllers.UserController;
import com.taskTracker.tasks.user.api.requests.ChangePasswordRequest;
import com.taskTracker.tasks.user.api.requests.ProfileUpdateRequest;
import com.taskTracker.tasks.user.application.usecases.ChangePasswordUseCase;
import com.taskTracker.tasks.user.application.usecases.DeactivateAccountUseCase;
import com.taskTracker.tasks.user.application.usecases.DeleteAccountUseCase;
import com.taskTracker.tasks.user.application.usecases.GetUserUseCase;
import com.taskTracker.tasks.user.application.usecases.UserProfileUpdateUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
public class UserControllerImpl implements UserController {
    private final UserProfileUpdateUseCase userProfileUpdateUseCase;
    private final ChangePasswordUseCase changePasswordUseCase;
    private final DeactivateAccountUseCase deactivateAccountUseCase;
    private final DeleteAccountUseCase deleteAccountUseCase;
    private final GetUserUseCase getUserUseCase;

    @Override
    @PatchMapping("/api/me/{userId}")
    public ResponseEntity<ApiResponse> updateUserProfile(@RequestBody ProfileUpdateRequest request,@PathVariable UUID userId) throws BusinessException {
        System.out.println(userId.toString());
        this.userProfileUpdateUseCase.execute(request, userId);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> changePassword(@RequestBody @Valid ChangePasswordRequest request, UUID userId) {
        this.changePasswordUseCase.execute(request, userId);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deactivateAccount(UUID userId) {
        this.deactivateAccountUseCase.execute(userId);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteAccount(UUID userId) {
        this.deleteAccountUseCase.execute(userId);
        return new ResponseEntity("success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> getUser(UUID userId) {
        var userResponse = this.getUserUseCase.execute(userId);
        return new ResponseEntity<>(new ApiResponse<>("success", HttpStatus.OK, "User retrieved successfully", userResponse), HttpStatus.OK);
    }
}
