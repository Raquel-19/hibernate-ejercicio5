package com.example.hibernateejercicio5.service.impl;

import com.example.hibernateejercicio5.dao.UserDAO;
import com.example.hibernateejercicio5.model.User;
import com.example.hibernateejercicio5.repository.UserRepository;
import com.example.hibernateejercicio5.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    private final UserRepository repositoryUser;

    public UserServiceImpl(UserDAO userDAO, UserRepository repositoryUser) {
        this.userDAO = userDAO;
        this.repositoryUser = repositoryUser;
    }

    @Override
    public List<User> findAllUser() {
        List<User> results = this.userDAO.findAllUser();
        System.out.println("--------");
        return results;
    }

    @Override
    public User findUserId(Long id) {
        User results = this.userDAO.findUserId(id);
        System.out.println("--------");
        return results;
    }
    @Override
    public List<User> filterByActive (Boolean isActive) {
        List<User> results = this.userDAO.filterByActive(isActive);
        System.out.println("--------");
        return results;
    }

    @Override
    public User createUser (User userdata) {
        return repositoryUser.save(userdata);
    }

    @Override
    public User updateUser (User userdata2) {
        return repositoryUser.save(userdata2);
    }
}
