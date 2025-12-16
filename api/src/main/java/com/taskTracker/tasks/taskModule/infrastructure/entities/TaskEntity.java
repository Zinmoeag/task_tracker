package com.taskTracker.tasks.taskModule.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private String dueDate;

    @Column(name = "complete_date", nullable = true)
    private String completedDate;

    @Column(name = "status", nullable = false,  length = 30)
    private TaskStatusEntity status;

    @Column(name = "priority", nullable = true)
    private TaskProrityEntity priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_list_id")
    private TaskListEntity taskList;

    @Column(name = "created_At",  nullable = true)
    private LocalDateTime created;

    @Column(name = "updated_At", nullable = true)
    private LocalDateTime updated;
}
