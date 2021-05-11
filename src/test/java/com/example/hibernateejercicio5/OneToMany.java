package com.example.hibernateejercicio5;

import com.example.hibernateejercicio5.model.Task;
import com.example.hibernateejercicio5.model.User;
import com.example.hibernateejercicio5.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class OneToMany {

    @Test
    @DisplayName("Asignar a un usuario algunas tareas")
    public void checkTask () {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Task task1 = new Task(391L, "Logistica", "Logistica interna", "Realizar operaciones de...", LocalDate.now(), false);
        Task task2 = new Task(377L, "Conferencia", "Conferencia con la empresa SA", "Acudir a la conferencia...",  LocalDate.now(),true );

        User user = new User(499L, "Alvaro", "Diaz", "77896547Y", true, LocalDate.now());

        session.beginTransaction();

        user.getTasks().add(task1);
        user.getTasks().add(task2);

        session.save(task1);
        session.save(task2);
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}
