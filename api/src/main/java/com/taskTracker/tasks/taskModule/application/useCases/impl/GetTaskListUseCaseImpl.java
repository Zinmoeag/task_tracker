package com.taskTracker.tasks.taskModule.application.useCases.impl;

import com.taskTracker.tasks.taskModule.api.dtos.TaskListDTO;
import com.taskTracker.tasks.taskModule.application.services.TaskListRespositoryService;
import com.taskTracker.tasks.taskModule.application.useCases.GetTaskListUseCase;
import com.taskTracker.tasks.taskModule.domain.exception.TaskListNotFoundExecption;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskListEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class GetTaskListUseCaseImpl implements GetTaskListUseCase {

    private final TaskListRespositoryService taskListRespositoryService;

    @Override
    public Optional<TaskListEntity> execute(UUID id) {
        return taskListRespositoryService.getTaskListById(id);
    }

    @Override
    public Optional<TaskListEntity> execute(String name) {
        return null;
    }
}
