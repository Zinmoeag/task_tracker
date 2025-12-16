package com.taskTracker.tasks.taskModule.api.controllers.impl;

import com.taskTracker.tasks.core.response.ApiResponse;
import com.taskTracker.tasks.taskModule.domain.exception.TaskListNotFoundExecption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception ex, WebRequest request) {
        ApiResponse response = new ApiResponse(
                "FAILED", HttpStatus.BAD_REQUEST, ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TaskListNotFoundExecption.class)
    public ResponseEntity<ApiResponse> handleException(TaskListNotFoundExecption ex, WebRequest request) {
        ApiResponse response = new ApiResponse(
                "FAILED", HttpStatus.NOT_FOUND, ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleException(IllegalArgumentException ex, WebRequest request) {
        ApiResponse response = new ApiResponse(
                "FAILED", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
