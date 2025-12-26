package com.taskTracker.tasks.auth.api.controllers;

import com.taskTracker.tasks.auth.api.requests.AuthenticationRequest;
import com.taskTracker.tasks.auth.api.requests.RegistrationRequest;
import com.taskTracker.tasks.auth.api.responses.AuthenticationResponse;
import com.taskTracker.tasks.core.exceptions.BusinessException;
import com.taskTracker.tasks.core.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationController {
    ResponseEntity<ApiResponse> register(RegistrationRequest request) throws BusinessException;
    ResponseEntity<ApiResponse> login(AuthenticationRequest request) throws BusinessException;
}

