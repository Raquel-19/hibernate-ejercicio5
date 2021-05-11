package com.example.hibernateejercicio5.service;

import com.example.hibernateejercicio5.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAllTask();
    Task findTaskId(Long id);
    List<Task> filterByFinalized(Boolean isFinalized);

    Task createTask(Task taskdata);
    Task updateTask(Task taskdata2);

}
