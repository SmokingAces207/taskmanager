package com.josephocallaghan.taskmanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.josephocallaghan.taskmanager.dto.TaskDto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Task {

	@Id
	@GeneratedValue
	private Integer id;

	@NonNull
	private String title;
	
	private String description;
	
	private String dueDate;
	
	private String priority;
	
	private String comments;

	private Boolean completed = false;
	
	private Boolean editing = false;
	
	public Task (TaskDto taskDto) {
		this.id = taskDto.getId();
		this.title = taskDto.getTitle();
		this.description = taskDto.getDescription();
		this.dueDate = taskDto.getDueDate();
		this.priority = taskDto.getPriority();
		this.comments = taskDto.getComments();
		this.completed = taskDto.getCompleted();
		this.editing = taskDto.getEditing();
	}
	
}
