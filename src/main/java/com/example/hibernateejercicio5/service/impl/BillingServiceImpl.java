package com.example.hibernateejercicio5.service.impl;

import com.example.hibernateejercicio5.dao.BillingDAO;
import com.example.hibernateejercicio5.model.BillingInfo;
import com.example.hibernateejercicio5.repository.BillingRepository;
import com.example.hibernateejercicio5.service.BillingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    private final BillingDAO billingDAO;

    private final BillingRepository repositoryBilling;


    public BillingServiceImpl(BillingDAO billingDAO, BillingRepository repositoryBilling) {
        this.billingDAO = billingDAO;
        this.repositoryBilling = repositoryBilling;
    }

    @Override
    public List<BillingInfo> findAllBilling() {
        List<BillingInfo> results = this.billingDAO.findAllBilling();
        System.out.println("--------");
        return results;
    }

    @Override
    public BillingInfo findBillingId(Long id) {
        BillingInfo results = this.billingDAO.findBillingId(id);
        System.out.println("--------");
        return results;
    }
    @Override
    public List<BillingInfo> filterByAddress (String address) {
        List<BillingInfo> results = this.billingDAO.filterByAddress(address);
        System.out.println("--------");
        return results;
    }

    @Override
    public BillingInfo createBilling (BillingInfo billingdata) {
        return repositoryBilling.save(billingdata);
    }

    @Override
    public BillingInfo updateBilling (BillingInfo billingdata2) {
        return repositoryBilling.save(billingdata2);
    }
}
