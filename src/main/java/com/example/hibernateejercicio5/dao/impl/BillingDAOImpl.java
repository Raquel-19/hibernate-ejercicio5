package com.example.hibernateejercicio5.dao.impl;

import com.example.hibernateejercicio5.dao.BillingDAO;
import com.example.hibernateejercicio5.model.BillingInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BillingDAOImpl implements BillingDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<BillingInfo> findAllBilling() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<BillingInfo> criteriaBilling = builder.createQuery(BillingInfo.class);
        Root<BillingInfo> root = criteriaBilling.from(BillingInfo.class);
        criteriaBilling.select(root);

        return manager.createQuery(criteriaBilling).getResultList();
    }

    @Override
    public BillingInfo findBillingId (Long id) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<BillingInfo> criteriaBilling2 = builder.createQuery(BillingInfo.class);
        Root<BillingInfo> root = criteriaBilling2.from(BillingInfo.class);
        criteriaBilling2.select(root);
        criteriaBilling2.where(builder.equal(root.get("id"), id));

        return manager.createQuery(criteriaBilling2).getSingleResult();
    }

    public List<BillingInfo> filterByAddress (String address) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<BillingInfo> criteriaBilling3 = builder.createQuery(BillingInfo.class);
        Root<BillingInfo> root = criteriaBilling3.from(BillingInfo.class);
        criteriaBilling3.select(root);
        criteriaBilling3.where(builder.equal(root.get("address"), address));

        return manager.createQuery(criteriaBilling3).getResultList();
    }
}
