package com.example.hibernateejercicio5.controller;

import com.example.hibernateejercicio5.model.Task;
import com.example.hibernateejercicio5.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * RETRIEVE - Find all tasks
     * @return The call from TaskService
     */
    @GetMapping("/tasks")
    public List<Task> findAllTask() {
        return taskService.findAllTask();
    }

    /**
     * RETRIEVE - Find task by id
     * @param id Long Primary key - The number by which it will be filtered
     * @return The call from TaskService
     */
    @GetMapping("/task_id")
    public Task findTaskId (@RequestParam Long id) {
        return taskService.findTaskId(id);
    }

    /**
     * RETRIEVE - Filter task by state
     * @param isFinalized Boolean - The parameter by which it will be filtered
     * @return The call from TaskService
     */
    @GetMapping("/task_finalized")
    public List<Task> filterByColor (@RequestParam Boolean isFinalized) {
        return taskService.filterByFinalized(isFinalized);
    }

    /**
     * CREATE - Create task in Postman
     * @param taskdata The name by which it will be filtered
     * @return The call from TaskService
     */
    @PostMapping("/tasks_create")
    public Task createTask (@RequestBody Task taskdata) {
        return taskService.createTask(taskdata);
    }

    /**
     * UPDATE - Update an user in Postman
     * @param taskdata2 The name by which it will be filtered
     * @return The call from TaskService
     */
    @PutMapping("/tasks_update")
    public Task updateTask (@RequestBody Task taskdata2) {
        return taskService.updateTask(taskdata2);
    }

}
