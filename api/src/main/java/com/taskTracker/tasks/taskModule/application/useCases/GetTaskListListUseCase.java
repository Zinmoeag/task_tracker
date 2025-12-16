package com.taskTracker.tasks.taskModule.application.useCases;

import com.taskTracker.tasks.taskModule.api.dtos.TaskListDTO;

import java.util.List;

public interface GetTaskListListUseCase {
    List<TaskListDTO> execute();
}
