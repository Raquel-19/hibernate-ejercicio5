package com.example.hibernateejercicio5.model;

import javax.persistence.*;

/**
 * Información de facturación de un usuario
 */
@Entity
@Table (name = "billing")
public class BillingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private Long telephone;

    @OneToOne (mappedBy = "billing", fetch = FetchType.EAGER)
    private User user;

    public BillingInfo() {
    }

    public BillingInfo(Long numberBilling, String address, Long telephone) {
        this.id = numberBilling;
        this.address = address;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BillingInfo{" +
                "numberBilling=" + id +
                ", address='" + address + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
