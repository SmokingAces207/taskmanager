package com.josephocallaghan.taskmanager.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.josephocallaghan.taskmanager.service.ITaskBusinessService;

public abstract class BaseRestController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	protected ITaskBusinessService taskBusinessService;
	
}
