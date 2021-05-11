package com.example.hibernateejercicio5.dao;

import com.example.hibernateejercicio5.model.User;

import java.util.List;

public interface UserDAO {

    List<User> findAllUser();
    User findUserId(Long id);
    List<User> filterByActive(Boolean isActive);

}
