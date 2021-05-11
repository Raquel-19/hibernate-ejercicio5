package com.example.hibernateejercicio5;

import com.example.hibernateejercicio5.model.BillingInfo;
import com.example.hibernateejercicio5.model.User;
import com.example.hibernateejercicio5.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class OneToOne {

    @Test
    @DisplayName("Asociar un usuario con una facturación")
    public void asociateUserAndBilling() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        User user = new User(345L, "Paco", "Garcia", "7548245Y", false, LocalDate.now());
        BillingInfo billing = new BillingInfo(366L, "Calle Margarita", 952468544L);

        user.setBillingInfo(billing);

        session.save(billing);
        session.save(user);

        session.getTransaction();

        session.close();
    }
}