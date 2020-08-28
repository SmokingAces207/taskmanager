package com.josephocallaghan.taskmanager.service;

import java.util.List;

import com.josephocallaghan.taskmanager.dto.TaskDto;

public interface ITaskBusinessService {

	List<TaskDto> getAllTasks();
	
	TaskDto saveTask(final TaskDto taskToSave);

	void deleteTask(final Integer taskId);

}
