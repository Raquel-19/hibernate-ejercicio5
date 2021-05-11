package com.example.hibernateejercicio5.service;

import com.example.hibernateejercicio5.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();
    User findUserId(Long id);
    List<User> filterByActive (Boolean isActive);

    User createUser(User userdata);
    User updateUser(User userdata2);
}
