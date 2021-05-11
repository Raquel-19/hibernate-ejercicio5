package com.example.hibernateejercicio5.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "last_name")
    private String lastName;

    @Column (name= "dni")
    private String dni;

    @Column (name="is_active")
    //@Type(type = "yes_no")
    private Boolean isActive;

    @Column (name = "birth_date")
    private LocalDate birthDate;

    @OneToMany (mappedBy = "user")
    @OrderBy ("name")
    private List<Task> tasks = new ArrayList<>();

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_billing")
    private BillingInfo billing;


    public User () {}

    public User(Long id, String name, String lastName, String dni, Boolean isActive, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.isActive = isActive;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public BillingInfo getBillingInfo() {
        return billing;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billing = billingInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", isActive=" + isActive +
                ", birthDate=" + birthDate +
                '}';
    }
}
