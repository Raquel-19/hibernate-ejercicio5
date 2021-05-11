package com.example.hibernateejercicio5.controller;

import com.example.hibernateejercicio5.model.BillingInfo;
import com.example.hibernateejercicio5.service.BillingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillingInfoController {

    private final BillingService billingService;

    public BillingInfoController(BillingService billingService) {
        this.billingService = billingService;
    }
    /**
     * RETRIEVE - Find all billings
     * @return The call from BillingService
     */
    @GetMapping("/billings")
    public List<BillingInfo> findAllBilling () {
        return billingService.findAllBilling();
    }

    /**
     * RETRIEVE - Find billings by id
     * @param id Long Primary key - The number by which it will be filtered
     * @return The call from BillingService
     */
    @GetMapping("/billing_id")
    public BillingInfo findBillingId (@RequestParam Long id) {
        return billingService.findBillingId(id);
    }

    /**
     * RETRIEVE - Filter billing by address
     * @param address String - The parameter by which it will be filtered
     * @return The call from BillingService
     */
    @GetMapping("/billing_address")
    public List<BillingInfo> filterByAddress (@RequestParam String address) {
        return billingService.filterByAddress(address);
    }

    /**
     * CREATE - Create billings in Postman
     * @param billingdata The name by which it will be filtered
     * @return The call from BillingService
     */
    @PostMapping("/billings_create")
    public BillingInfo createBilling (@RequestBody BillingInfo billingdata) {
        return billingService.createBilling(billingdata);
    }

    /**
     * UPDATE - Update an billing in Postman
     * @param billingdata2 The name by which it will be filtered
     * @return The call from BillingService
     */
    @PutMapping("/billings_update")
    public BillingInfo updateBilling (@RequestBody BillingInfo billingdata2) {
        return billingService.updateBilling(billingdata2);
    }
}
