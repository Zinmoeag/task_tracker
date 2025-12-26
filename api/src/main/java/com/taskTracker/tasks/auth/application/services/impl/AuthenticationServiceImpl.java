package com.taskTracker.tasks.auth.application.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.taskTracker.tasks.auth.api.requests.AuthenticationRequest;
import com.taskTracker.tasks.auth.api.requests.RefreshAccessTokenRequest;
import com.taskTracker.tasks.auth.api.requests.RegistrationRequest;
import com.taskTracker.tasks.auth.api.responses.AuthenticationResponse;
import com.taskTracker.tasks.auth.application.converters.AuthenticationMapper;
import com.taskTracker.tasks.auth.application.services.AuthenticationService;
import com.taskTracker.tasks.core.exceptions.BusinessException;
import com.taskTracker.tasks.core.exceptions.ErrorCode;
import com.taskTracker.tasks.security.JwtService;
import com.taskTracker.tasks.user.application.port.RoleRepository;
import com.taskTracker.tasks.user.application.port.UserRespository;
import com.taskTracker.tasks.user.entities.RoleEntity;
import com.taskTracker.tasks.user.entities.UserEntity;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRespository userRespository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final AuthenticationMapper authenticationMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegistrationRequest request) throws BusinessException {
            System.out.println("Registering User ....");
        // check user email
        if(this.checkUserEmailExists(request.getEmail())) {
            throw new BusinessException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }
        // check comfirm password is correnct
        if(!this.checkConfirmPasswordIsCorrect(request.getPassword(), request.getConfirmPassword())) {
            throw new BusinessException(ErrorCode.PASSWORD_MISMATCH);
        }

        final RoleEntity role = this.roleRepository.findByName("ADMIN")
            .orElseThrow(() -> new BusinessException(ErrorCode.BAD_CREDENTIALS));

        final List<RoleEntity> roles = new ArrayList<>();
        roles.add(role);

        // store
        final UserEntity user = this.authenticationMapper.toEntity(request, roles);
        this.userRespository.save(user);


    }

    private boolean checkConfirmPasswordIsCorrect(String password, String confirmPassword) {
        if(!password.equals(confirmPassword)) {
            return false;
        }
        return true;
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        Authentication authentication = this.authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail() , request.getPassword())
        );
        final UserEntity user = (UserEntity) authentication.getPrincipal();
        final String accessToken = this.jwtService.generateAccessToken(user.getEmail());
        final String refreshToken = this.jwtService.generateRefreshToken(user.getEmail());
        final String tokenType = "Bearer";

        return AuthenticationResponse.builder()
            .accessToken(accessToken)
            .refreshToken(refreshToken)
            .tokenType(tokenType)
            .build();
    }

    @Override
    public AuthenticationResponse refreshToken(RefreshAccessTokenRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'refreshToken'");
    }

    private boolean checkUserEmailExists(String email) {
        if(!this.userRespository.existsByEmailIgnoreCase(email)) {
            return false;
        }
        return true;
    }
    
}
