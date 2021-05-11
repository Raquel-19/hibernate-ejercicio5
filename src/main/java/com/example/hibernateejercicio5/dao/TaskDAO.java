package com.example.hibernateejercicio5.dao;

import com.example.hibernateejercicio5.model.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> findAllTask();
    Task findTaskId(Long id);
    List<Task> filterByFinalized (Boolean isFinalized);
}
