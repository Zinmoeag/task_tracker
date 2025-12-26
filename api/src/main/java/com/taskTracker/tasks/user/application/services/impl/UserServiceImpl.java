package com.taskTracker.tasks.user.application.services.impl;

import com.taskTracker.tasks.core.exceptions.BusinessException;
import com.taskTracker.tasks.core.exceptions.ErrorCode;
import com.taskTracker.tasks.user.api.dtos.UserDTO;
import com.taskTracker.tasks.user.api.requests.ChangePasswordRequest;
import com.taskTracker.tasks.user.api.requests.ProfileUpdateRequest;
import com.taskTracker.tasks.user.application.converters.UserMapper;
import com.taskTracker.tasks.user.application.port.UserRespository;
import com.taskTracker.tasks.user.application.services.UserService;
import com.taskTracker.tasks.user.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.taskTracker.tasks.core.exceptions.ErrorCode.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRespository userRepository;
    private final UserMapper userMapper;
    public final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new BusinessException(USER_NOT_FOUND));
    }

    @Override
    public void updateProfileInfo(ProfileUpdateRequest request, UUID userId) throws BusinessException {
        UserEntity savedUser = this.userRepository.findById(userId)
                .orElseThrow(() ->  new BusinessException(USER_NOT_FOUND));

        savedUser.setFirstName(request.getFirstName());
        savedUser.setLastName(request.getLastName());
        savedUser.setDateOfBirth(request.getDateOfBirth());

        this.userRepository.save(savedUser);
    }

    @Override
    public void changePassword(ChangePasswordRequest request, UUID userId) {
        if(!request.getNewPassword().equals(request.getConfirmNewPassword())) {
            throw new BusinessException(CHANGE_PASSWORD_MISMATCH);
        }
        final UserEntity user = this.userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(USER_NOT_FOUND));

        if(!this.passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new BusinessException(INVALID_CURRENT_PASSWORD);
        }

        String encoded = this.passwordEncoder.encode(request.getNewPassword());
        user.setPassword(encoded);
        this.userRepository.save(user);
    }

    @Override
    public void deactivateAccount(UUID userId) {
        final UserEntity user = this.userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(USER_NOT_FOUND));

        if(!user.isEnabled()) {
            throw new BusinessException(ErrorCode.ACCOUNT_ALREADY_DEACTIVATED);
        }
        user.setEnabled(false);
        this.userRepository.save(user);
    }

    @Override
    public void reactivateAccount(UUID userId) {
        final UserEntity user = this.userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(USER_NOT_FOUND));

        if(!user.isEnabled()) {
            throw new BusinessException(ErrorCode.ACCOUNT_ALREADY_DEACTIVATED);
        }
        user.setEnabled(true);
        this.userRepository.save(user);
    }

    @Override
    public void deleteAccount(UUID userId) {
        this.userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(USER_NOT_FOUND));
        this.userRepository.deleteById(userId);
    }

    @Override
    public UserDTO getUserById(UUID userId) {
        UserEntity user = this.userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(USER_NOT_FOUND));
        
        return this.userMapper.toDTO(user);
    }
}
