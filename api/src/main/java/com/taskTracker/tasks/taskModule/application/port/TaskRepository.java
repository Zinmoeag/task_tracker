package com.taskTracker.tasks.taskModule.application.port;

import com.taskTracker.tasks.taskModule.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
    List<TaskEntity> findByTaskListId(UUID id);
    Optional<TaskEntity> findByTaskListIdAndId(UUID taskId, UUID id);
}
