package com.example.hibernateejercicio5.service.impl;

import com.example.hibernateejercicio5.dao.TaskDAO;
import com.example.hibernateejercicio5.model.Task;
import com.example.hibernateejercicio5.repository.TaskRepository;
import com.example.hibernateejercicio5.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;

    private final TaskRepository repositoryTask;

    public TaskServiceImpl(TaskDAO taskDAO, TaskRepository repositoryTask) {
        this.taskDAO = taskDAO;
        this.repositoryTask = repositoryTask;
    }

    @Override
    public List<Task> findAllTask () {
        List<Task> results = this.taskDAO.findAllTask();
        System.out.println("--------");
        return results;
    }

    @Override
    public Task findTaskId(Long id) {
        Task results = this.taskDAO.findTaskId(id);
        System.out.println("--------");
        return results;
    }

    @Override
    public List<Task> filterByFinalized (Boolean isFinalized) {
        List<Task> results = this.taskDAO.filterByFinalized(isFinalized);
        System.out.println("--------");
        return results;
    }

    @Override
    public Task createTask(Task taskdata) {
        return repositoryTask.save(taskdata);
    }

    @Override
    public Task updateTask (Task taskdata2) {
        return repositoryTask.save(taskdata2);
    }
}
