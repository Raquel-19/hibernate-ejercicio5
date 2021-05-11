package com.example.hibernateejercicio5.dao.impl;

import com.example.hibernateejercicio5.dao.UserDAO;
import com.example.hibernateejercicio5.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> findAllUser() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaUser = builder.createQuery(User.class);
        Root<User> root = criteriaUser.from(User.class);
        criteriaUser.select(root);

        return manager.createQuery(criteriaUser).getResultList();
    }

    @Override
    public User findUserId(Long id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaUser2 = builder.createQuery(User.class);
        Root<User> root = criteriaUser2.from(User.class);
        criteriaUser2.select(root);
        criteriaUser2.where(builder.equal(root.get("id"), id));

        return manager.createQuery(criteriaUser2).getSingleResult();
    }

    @Override
    public List<User> filterByActive(Boolean isActive) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaUser3 = builder.createQuery(User.class);
        Root<User> root = criteriaUser3.from(User.class);
        criteriaUser3.select(root);
        criteriaUser3.where(builder.equal(root.get("isActive"), isActive));

        return manager.createQuery(criteriaUser3).getResultList();
    }
}
