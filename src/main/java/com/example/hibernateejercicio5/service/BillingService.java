package com.example.hibernateejercicio5.service;

import com.example.hibernateejercicio5.model.BillingInfo;

import java.util.List;

public interface BillingService {

    List<BillingInfo> findAllBilling ();
    BillingInfo findBillingId(Long id);
    List<BillingInfo> filterByAddress(String address);

    BillingInfo createBilling(BillingInfo billingdata);
    BillingInfo updateBilling(BillingInfo billingdata2);
}
