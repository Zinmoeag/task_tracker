package com.taskTracker.tasks.taskModule.api.responses;

import com.taskTracker.tasks.core.response.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TaskListResponse<T> extends ApiResponse<T> {}
