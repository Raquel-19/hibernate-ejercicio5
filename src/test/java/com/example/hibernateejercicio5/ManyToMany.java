package com.example.hibernateejercicio5;

import com.example.hibernateejercicio5.model.Tag;
import com.example.hibernateejercicio5.model.Task;
import com.example.hibernateejercicio5.util.HibernateUtil;
import org.apache.tomcat.jni.Local;
import org.hibernate.Session;
import org.hibernate.annotations.Type;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import javax.persistence.Column;
import java.time.LocalDate;

public class ManyToMany {

    @Test
    @DisplayName("Crear una etiquetas y asociarlas con una tarea")
    public void createTag () {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Tag tag1 = new Tag(123L, "MySql", "Green");
        Tag tag2 = new Tag(289L, "Angular", "Red");

        Task task1 = new Task(457L, "Desarrollo backend", "Proyecto LS ", "App para la empresa LS...",  LocalDate.now(), false);
        Task task2 = new Task(890L, "Desarrollo frontend", "Proyecto PA ", "App para la empresa PA...", LocalDate.now(), false);

        task1.getTags().add(tag1);
        task2.getTags().add(tag2);

        session.save(tag1);
        session.save(tag2);
        session.save(task1);
        session.save(task2);

        session.getTransaction().commit();

        session.close();
    }

    @Test
    @DisplayName("Borrar algunas etiquetas de varias tareas")
    public void deleteFromTask () {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Tag tag1 = new Tag(345L, "Java", "Yellow");
        Tag tag2 = new Tag(897L, "React", "Blue");

        Task task1 = new Task(500L, "Desarrollo App", "Proyecto SA", "App para la empresa SA...", LocalDate.now(), false);

        task1.getTags().add(tag1);
        task1.getTags().add(tag2);

        session.save(tag1);
        session.save(tag2);
        session.save(task1);

        session.getTransaction().commit();

        session.close();

        System.out.println("--------------------");
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Task task = session.find(Task.class, task1.getId());
        task.getTags().remove(0);
        session.save(task);

        session.getTransaction().commit();
        session.close();
    }
}
