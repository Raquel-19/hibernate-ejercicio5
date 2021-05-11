package com.example.hibernateejercicio5.controller;

import com.example.hibernateejercicio5.model.User;
import com.example.hibernateejercicio5.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * RETRIEVE - Find all users
     * @return The call from UserService
     */
    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAllUser();
    }

    /**
     * RETRIEVE - Find user by id
     * @param id Long Primary key - The number by which it will be filtered
     * @return The call from UserService
     */
    @GetMapping("/user_id")
    public User findUserId (@RequestParam Long id) {
        return userService.findUserId(id);
    }

    /**
     * RETRIEVE - Filter user by availability
     * @param isActive Boolean - The parameter by which it will be filtered
     * @return The call from UserService
     */
    @GetMapping("/user_active")
    public List<User> filterByActive (@RequestParam Boolean isActive) {
        return userService.filterByActive(isActive);
    }

    /**
     * CREATE - Create user in Postman
     * @param userdata The name by which it will be filtered
     * @return The call from UserService
     */
    @PostMapping("/users_create")
    public User createUser (@RequestBody User userdata) {
        return userService.createUser(userdata);
    }

    /**
     * UPDATE - Update an user in Postman
     * @param userdata2 The name by which it will be filtered
     * @return The method called from UserService
     */
    @PutMapping("/users_update")
    public User updateUser (@RequestBody User userdata2) {
        return userService.updateUser(userdata2);
    }
}
