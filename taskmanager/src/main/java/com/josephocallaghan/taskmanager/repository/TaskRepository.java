package com.josephocallaghan.taskmanager.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.josephocallaghan.taskmanager.domain.Task;

//@RepositoryRestResource
//public interface TaskRepository extends JpaRepository<Task, Long> {
//
//}

public interface TaskRepository extends PagingAndSortingRepository<Task, Integer> {

}