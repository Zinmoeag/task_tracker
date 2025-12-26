package com.taskTracker.tasks.auth.application.services;

import com.taskTracker.tasks.auth.api.requests.AuthenticationRequest;
import com.taskTracker.tasks.auth.api.requests.RefreshAccessTokenRequest;
import com.taskTracker.tasks.auth.api.requests.RegistrationRequest;
import com.taskTracker.tasks.auth.api.responses.AuthenticationResponse;
import com.taskTracker.tasks.core.exceptions.BusinessException;

public interface AuthenticationService {
    void register(RegistrationRequest request) throws BusinessException;
    AuthenticationResponse login(AuthenticationRequest request) throws BusinessException;
    AuthenticationResponse refreshToken(RefreshAccessTokenRequest request) throws BusinessException;
}
