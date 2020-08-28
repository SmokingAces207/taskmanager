package com.josephocallaghan.taskmanager.repository;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

import com.josephocallaghan.taskmanager.domain.Task;

/**
 * IDs are not returned by RestRepository by default. We are exposing them so
 * that the client can easily find the ID of created and listed resources.
 */
@Component
public class RestRepositoryConfigurator implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Task.class);
	}
}