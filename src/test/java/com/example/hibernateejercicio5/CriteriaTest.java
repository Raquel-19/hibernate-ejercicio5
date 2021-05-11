package com.example.hibernateejercicio5;

import com.example.hibernateejercicio5.model.Task;
import com.example.hibernateejercicio5.model.User;
import com.example.hibernateejercicio5.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaTest {

    @Test
    @DisplayName("Mostrar todas las tareas")
    public void queryAllTaskCriteria() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Task> criteriaTask = builder.createQuery(Task.class);
        Root<Task> root = criteriaTask.from(Task.class);
        criteriaTask.select(root);

        Query<Task> query = session.createQuery(criteriaTask);
        List<Task> tasks = query.list();
        System.out.println(tasks);
        session.close();
    }

    @Test
    @DisplayName("Encontrar un usuario por id")
    public void findUserByIdCriteria() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaUser = builder.createQuery(User.class);
        Root<User> root = criteriaUser.from(User.class);

        criteriaUser.select(root);
        criteriaUser.where(builder.equal(root.get("id"), 2L));
        List<User> users = session.createQuery(criteriaUser).list();
        System.out.println(users);
        session.close();
    }
}
