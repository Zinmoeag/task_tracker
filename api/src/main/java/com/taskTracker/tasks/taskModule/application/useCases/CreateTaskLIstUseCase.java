package com.taskTracker.tasks.taskModule.application.useCases;

import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskListEntity;

public interface CreateTaskLIstUseCase {
    TaskListEntity execute(TaskListEntity taskListEntity);
}
