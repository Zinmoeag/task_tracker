package com.taskTracker.tasks.taskModule.application.useCases.impl;

import com.taskTracker.tasks.taskModule.application.services.TaskListRespositoryService;
import com.taskTracker.tasks.taskModule.application.useCases.CreateTaskLIstUseCase;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskListEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CreateTaskListUseCaseImpl implements CreateTaskLIstUseCase {

    private final TaskListRespositoryService taskListRespositoryService;

    @Override
    public TaskListEntity execute(TaskListEntity taskListEntity) {
        try {
            return taskListRespositoryService.createTaskList(taskListEntity);
        }catch (Exception ex){
            throw ex;
        }
    }
}
