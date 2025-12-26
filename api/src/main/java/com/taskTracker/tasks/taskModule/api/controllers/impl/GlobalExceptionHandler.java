package com.taskTracker.tasks.taskModule.api.controllers.impl;

import com.taskTracker.tasks.core.exceptions.BusinessException;
import com.taskTracker.tasks.core.response.ApiResponse;
import com.taskTracker.tasks.taskModule.domain.exception.TaskListNotFoundExecption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse> handleBusinessException(BusinessException ex, WebRequest request) {
        System.out.println("BusinessException");
        HttpStatus status = ex.getErrorCode().getStatus();
        ApiResponse response = new ApiResponse(
                "FAILED", status, ex.getMessage()
        );
        return new ResponseEntity<>(response, status);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception ex, WebRequest request) {
        System.out.println("Exception");
        ApiResponse response = new ApiResponse(
                "FAILED", HttpStatus.BAD_REQUEST, ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TaskListNotFoundExecption.class)
    public ResponseEntity<ApiResponse> handleException(TaskListNotFoundExecption ex, WebRequest request) {
        System.out.println("TaskListNotFoundExecption");
        ApiResponse response = new ApiResponse(
                "FAILED", HttpStatus.NOT_FOUND, ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleException(IllegalArgumentException ex, WebRequest request) {
        System.out.println("IllegalArgumentException");
        ApiResponse response = new ApiResponse(
                "FAILED", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
