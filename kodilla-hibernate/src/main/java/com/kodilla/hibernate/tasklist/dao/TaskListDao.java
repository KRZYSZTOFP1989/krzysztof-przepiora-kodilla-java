package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.dao.Respository;
import com.kodilla.hibernate.tasklist.TaskList;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


public interface TaskListDao extends CrudRepository<TaskList, Integer> {

    @Transactional
    @Respository
    List<TaskList> findByListName(String listName);

}
