package com.example.hibernateejercicio5.dao.impl;

import com.example.hibernateejercicio5.dao.TaskDAO;
import com.example.hibernateejercicio5.model.Task;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Task> findAllTask() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Task> criteriaTask = builder.createQuery(Task.class);
        Root<Task> root = criteriaTask.from(Task.class);
        criteriaTask.select(root);

        return manager.createQuery(criteriaTask).getResultList();
    }

    @Override
    public Task findTaskId (Long id) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Task> criteriaTask2 = builder.createQuery(Task.class);
        Root<Task> root = criteriaTask2.from(Task.class);
        criteriaTask2.select(root);
        criteriaTask2.where(builder.equal(root.get("id"), id));

        return manager.createQuery(criteriaTask2).getSingleResult();
    }
    @Override
    public List<Task> filterByFinalized (Boolean isFinalized) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Task> criteriaTask3 = builder.createQuery(Task.class);
        Root<Task> root = criteriaTask3.from(Task.class);
        criteriaTask3.select(root);
        criteriaTask3.where(builder.equal(root.get("isFinalized"), isFinalized));

        return manager.createQuery(criteriaTask3).getResultList();
    }
}
