package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


import java.util.Date;
import java.util.List;
import java.util.Set;


@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    @Column(name = "name")
    private String Name;

    @NotBlank(message = "El apellido es requerido")
    @Column(name = "lastname")
    private String LastName;

    @NotBlank(message = "El email es requerido")
    @Column(name = "email")
    private String Email;

    @NotBlank(message = "La contraseña es requerido")
    @Column(name = "password")
    private String Password;

    @NotBlank(message = "El telefono es requerido")
    @Column(name = "phone")
    private String Phone;

    @NotBlank(message = "El dirección es requerido")
    @Column(name = "address")
    private String Address;

    @NotBlank(message = "La fecha de nacimiento es requerido")
    @Column(name = "registrationdate")
    private Date RegistrationDate;

    @NotBlank(message = "El estado es requerido")
    @Column(name = "state")
    private int State;

    @ManyToOne
    @JoinColumn(name = "roleid",nullable = false)
    private Role role;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
    private Set<Order> orders;


    public User() {
    }

    public User(Integer id, String name, String lastName, String email, String password, String phone, String address, Date registrationDate, int state, Role role, Set<Order> orders) {
        this.id = id;
        Name = name;
        LastName = lastName;
        Email = email;
        Password = password;
        Phone = phone;
        Address = address;
        RegistrationDate = registrationDate;
        State = state;
        this.role = role;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public  String getName() {
        return Name;
    }

    public void setName( String name) {
        Name = name;
    }

    public  String getLastName() {
        return LastName;
    }

    public void setLastName( String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail( String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone( String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress( String address) {
        Address = address;
    }

    public  Date getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate( Date registrationDate) {
        RegistrationDate = registrationDate;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public Role getRoles() {
        return role;
    }

    public void setRoles(Role roles) {
        this.role = role;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
