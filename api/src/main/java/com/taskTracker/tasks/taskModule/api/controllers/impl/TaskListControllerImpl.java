package com.taskTracker.tasks.taskModule.api.controllers.impl;

import com.taskTracker.tasks.core.response.ApiResponse;
import com.taskTracker.tasks.taskModule.api.controllers.TaskListController;
import com.taskTracker.tasks.taskModule.api.dtos.TaskListDTO;
import com.taskTracker.tasks.taskModule.application.converters.TaskListMapper;
import com.taskTracker.tasks.taskModule.application.useCases.CreateTaskLIstUseCase;
import com.taskTracker.tasks.taskModule.application.useCases.GetTaskListListUseCase;
import com.taskTracker.tasks.taskModule.domain.exception.TaskListNotFoundExecption;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskListEntity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController("/api")
public class TaskListControllerImpl implements TaskListController {

    private final TaskListMapper taskListMapper;
    private final GetTaskListListUseCase getTaskListListUseCase;
    private final CreateTaskLIstUseCase createTaskLIstUseCase;

    @Override
    @GetMapping("/task-lists")
    public ResponseEntity<ApiResponse<List<TaskListDTO>>> getTaskListLists(UUID taskListId) {
        List<TaskListDTO> result = getTaskListListUseCase.execute();
        ApiResponse<List<TaskListDTO>> response = new ApiResponse<>(
                "SUCCESS", HttpStatus.OK, "Created", result
        );
        return new ResponseEntity(
                response, response.getCode()
        );
    }

    @Override
    @PostMapping("/task-lists")
    public ResponseEntity<ApiResponse<TaskListDTO>> createTaskList(@RequestBody TaskListDTO taskListDTO) {
        TaskListEntity taskListEntity = taskListMapper.toEntity(taskListDTO);
        TaskListEntity result = createTaskLIstUseCase.execute(taskListEntity);
        TaskListDTO resultDTO = taskListMapper.toDTO(result);

        ApiResponse<TaskListDTO> response = new ApiResponse<>(
                "SUCCESS", HttpStatus.CREATED, "Created", resultDTO
        );
        return new ResponseEntity(response, response.getCode());
    }
}
