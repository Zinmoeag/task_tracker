package com.taskTracker.tasks.auth.api.controllers.impl;

import com.taskTracker.tasks.auth.api.controllers.AuthenticationController;
import com.taskTracker.tasks.auth.api.requests.AuthenticationRequest;
import com.taskTracker.tasks.auth.api.requests.RegistrationRequest;
import com.taskTracker.tasks.auth.api.responses.AuthenticationResponse;
import com.taskTracker.tasks.auth.application.services.AuthenticationService;
import com.taskTracker.tasks.core.exceptions.BusinessException;
import com.taskTracker.tasks.core.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationService authenticationService;

    @Override
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody @Valid RegistrationRequest request) throws BusinessException {
        this.authenticationService.register(request);
        return new ResponseEntity<>(
                new ApiResponse<>("success", HttpStatus.CREATED, "User registered successfully"),
                HttpStatus.CREATED
        );
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody @Valid AuthenticationRequest request) throws BusinessException, BadCredentialsException {
        System.out.println(request + "==================================");
        AuthenticationResponse response = this.authenticationService.login(request);
        return new ResponseEntity<>(
                new ApiResponse<>("success", HttpStatus.OK, "Login successful", response),
                HttpStatus.OK
        );
    }
}

