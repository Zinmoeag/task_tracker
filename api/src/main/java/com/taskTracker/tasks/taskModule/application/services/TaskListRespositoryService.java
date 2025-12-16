package com.taskTracker.tasks.taskModule.application.services;

import com.taskTracker.tasks.taskModule.domain.exception.TaskListNotFoundExecption;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskEntity;
import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskListEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListRespositoryService {
    List<TaskListEntity> listsTasksLists();
    Optional<TaskListEntity> getTaskListById(UUID id) throws TaskListNotFoundExecption;
    Optional<TaskListEntity> getTaskListByName(String name) throws TaskListNotFoundExecption;
    TaskListEntity createTaskList(TaskListEntity taskListEntity);
}
