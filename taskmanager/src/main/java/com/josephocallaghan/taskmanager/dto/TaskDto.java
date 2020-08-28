package com.josephocallaghan.taskmanager.dto;

import com.josephocallaghan.taskmanager.domain.Task;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDto {

	private Integer id;

	private String title;
	
	private String description;
	
	private String dueDate;
	
	private String priority;
	
	private String comments;

	private Boolean completed = false;
	
	private Boolean editing = false;
	
	public TaskDto (Task task) {
		this.id = task.getId();
		this.title = task.getTitle();
		this.description = task.getDescription();
		this.dueDate = task.getDueDate();
		this.priority = task.getPriority();
		this.comments = task.getComments();
		this.completed = task.getCompleted();
		this.editing = task.getEditing();
	}
	
}
