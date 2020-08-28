package com.josephocallaghan.taskmanager.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josephocallaghan.taskmanager.config.AjaxResponse;
import com.josephocallaghan.taskmanager.dto.TaskDto;

@RequestMapping("/task")
@RestController
public class TaskRestController extends BaseRestController {

	@GetMapping("/")
	public AjaxResponse getAllTasks() {
		
		// Build Ajax Response Object for Front End
		AjaxResponse response = new AjaxResponse();
			
		// Get all tasks to return
		List<TaskDto> taskList = taskBusinessService.getAllTasks();
		
		response.getData().put("taskList", taskList);
		response.setSuccess(Boolean.TRUE);
		return response;
	}
	
	@PostMapping("/")
	public AjaxResponse createTask(@RequestBody TaskDto task) {
		
		// Build Ajax Response Object for Front End
		AjaxResponse response = new AjaxResponse();
			
		// Create task
		task = taskBusinessService.saveTask(task);
		
		response.getData().put("task", task);
		response.setSuccess(Boolean.TRUE);
		return response;
	}
	
	@PutMapping("/{id}")
	public AjaxResponse updateTask(@RequestBody TaskDto task) {
		
		// Build Ajax Response Object for Front End
		AjaxResponse response = new AjaxResponse();
			
		// Create task
		task = taskBusinessService.saveTask(task);
		
		response.getData().put("task", task);
		response.setSuccess(Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/{id}")
	public AjaxResponse deleteTask(@PathVariable("id") Integer id) {
		
		// Build Ajax Response Object for Front End
		AjaxResponse response = new AjaxResponse();
			
		// Delete task
		taskBusinessService.deleteTask(id);
		
		response.setSuccess(Boolean.TRUE);
		return response;
	}

}
