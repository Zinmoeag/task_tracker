package com.taskTracker.tasks.taskModule.api.controllers;

import com.taskTracker.tasks.core.response.ApiResponse;
import com.taskTracker.tasks.taskModule.api.dtos.TaskListDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface TaskListController {

    ResponseEntity<ApiResponse<TaskListDTO>> getTaskList(UUID id) throws Exception;
    ResponseEntity<ApiResponse<List<TaskListDTO>>> getTaskListLists(UUID taskListId);
    ResponseEntity<ApiResponse<TaskListDTO>> createTaskList(TaskListDTO taskListDTO);
}
