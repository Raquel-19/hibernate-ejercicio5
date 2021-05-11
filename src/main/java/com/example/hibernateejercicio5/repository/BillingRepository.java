package com.example.hibernateejercicio5.repository;

import com.example.hibernateejercicio5.model.BillingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<BillingInfo , Long> {
}
