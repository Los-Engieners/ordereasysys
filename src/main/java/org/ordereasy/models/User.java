package org.ordereasy.models;

import java.util.Date;
import java.util.List;

public class User {
    private int IdUser;
    private String Name;
    private String LastName;
    private String Email;
    private String Password;
    private String Phone;
    private String Address;
    private Date RegistrationDate;
    private int State;

    private Role roles;
    private List<Order> orders;

    private Role role;

    public User() {
    }

    public User(int idUser, String name, String lastName, String email, String password, String phone, String address, Date registrationDate, int state, Role role) {
        IdUser = idUser;
        Name = name;
        LastName = lastName;
        Email = email;
        Password = password;
        Phone = phone;
        Address = address;
        RegistrationDate = registrationDate;
        State = state;
        this.role = role;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
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

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Date getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        RegistrationDate = registrationDate;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
