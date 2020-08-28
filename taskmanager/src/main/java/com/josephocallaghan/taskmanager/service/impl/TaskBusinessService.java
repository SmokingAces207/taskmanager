package com.josephocallaghan.taskmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.josephocallaghan.taskmanager.domain.Task;
import com.josephocallaghan.taskmanager.dto.TaskDto;
import com.josephocallaghan.taskmanager.service.BaseBusinessService;
import com.josephocallaghan.taskmanager.service.ITaskBusinessService;

@Service
public class TaskBusinessService extends BaseBusinessService implements ITaskBusinessService {

	@Override
	public List<TaskDto> getAllTasks() {

		logger.info("Fetching all Tasks from database");
		Iterable<Task> taskEntityList = taskRepository.findAll();
		List<TaskDto> taskDtoList = new ArrayList<>();
		
		logger.info("Creating dto object list from entities");
		for (Task task : taskEntityList) {
			// Build each DTO object from the entity list
			TaskDto taskDto = new TaskDto(task);
			taskDtoList.add(taskDto);
		}
		return taskDtoList;
	}

	@Override
	public TaskDto saveTask(final TaskDto taskToSave) {
		
		// Create Entity from DTO and save
		Task newTask = new Task(taskToSave);
		logger.info("Saving new task: {}", newTask);
		newTask = taskRepository.save(newTask);
		
		// Return DTO
		return new TaskDto(newTask);
	}

	@Override
	public void deleteTask(final Integer taskId) {

		logger.info("Deleting task with id: {}", taskId);
		taskRepository.deleteById(taskId);
	}
	
}
