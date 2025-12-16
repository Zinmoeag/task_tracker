package com.taskTracker.tasks.taskModule.domain.exception;

public class TaskListNotFoundExecption extends RuntimeException {
    public TaskListNotFoundExecption(String message) {
        super(message);
    }
}
