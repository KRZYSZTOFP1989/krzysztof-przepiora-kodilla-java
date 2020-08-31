package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

interface TaskDao extends CrudRepository<Task, Integer> {

    @Respository
    @Transactional
    List<Task> findByDuration(int duration);


}