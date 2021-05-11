package com.example.hibernateejercicio5.dao;

import com.example.hibernateejercicio5.model.BillingInfo;

import java.util.List;

public interface BillingDAO {

    List<BillingInfo> findAllBilling ();
    BillingInfo findBillingId (Long id);
    List<BillingInfo> filterByAddress(String address);
}
