package com.example.hibernateejercicio5.dao.impl;

import com.example.hibernateejercicio5.dao.TagDAO;
import com.example.hibernateejercicio5.model.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TagDAOImpl implements TagDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Tag> findAllTag() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteriaTag = builder.createQuery(Tag.class);
        Root<Tag> root = criteriaTag.from(Tag.class);
        criteriaTag.select(root);

        return manager.createQuery(criteriaTag).getResultList();
    }

    @Override
    public Tag findTagId(Long id) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteriaTag2 = builder.createQuery(Tag.class);
        Root<Tag> root = criteriaTag2.from(Tag.class);
        criteriaTag2.select(root);
        criteriaTag2.where(builder.equal(root.get("id"), id));

        return manager.createQuery(criteriaTag2).getSingleResult();
    }

    @Override
    public List<Tag> filterByColor (String color) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteriaTag3 = builder.createQuery(Tag.class);
        Root<Tag> root = criteriaTag3.from(Tag.class);
        criteriaTag3.select(root);
        criteriaTag3.where(builder.equal(root.get("color"), color));

        return manager.createQuery(criteriaTag3).getResultList();
    }
}
