package com.taskTracker.tasks.taskModule.application.useCases;

import com.taskTracker.tasks.taskModule.api.dtos.TaskListDTO;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskListEntity;

import java.util.Optional;
import java.util.UUID;

public interface GetTaskListUseCase {
    Optional<TaskListEntity> execute(UUID id) throws  Exception;
    Optional<TaskListEntity> execute(String name) throws  Exception;
}
