package com.josephocallaghan.taskmanager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.josephocallaghan.taskmanager.repository.TaskRepository;

public abstract class BaseBusinessService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	protected TaskRepository taskRepository;
	
}
