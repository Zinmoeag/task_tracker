package com.taskTracker.tasks.core.response;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    private String status;
    private HttpStatus code;
    private String message;
    private T data;

    public ApiResponse() {
        super();
    }

    public ApiResponse(String status, HttpStatus code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ApiResponse(String status, HttpStatus code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HttpStatus getCode() {
        return this.code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
