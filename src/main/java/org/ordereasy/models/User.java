package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


import java.util.Date;
import java.util.Set;


@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "El apellido es requerido")
    @Column(name = "lastname")
    private String lastname;

    @NotBlank(message = "El email es requerido")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "La contraseña es requerido")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "El telefono es requerido")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "El dirección es requerido")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "La fecha de nacimiento es requerido")
    @Column(name = "registrationdate")
    private Date registrationdate;

    @NotBlank(message = "El estado es requerido")
    @Column(name = "state")
    private int state;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Ordr> ordrs;


    public User() {
    }

    public User(Integer id, String name, String lastname, String email, String password, String phone, String address, Date registrationdate, int state, Role role, Set<Ordr> ordrs) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.registrationdate = registrationdate;
        this.state = state;
        this.role = role;
        this.ordrs = ordrs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es requerido") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "El nombre es requerido") String name) {
        this.name = name;
    }

    public @NotBlank(message = "El apellido es requerido") String getLastname() {
        return lastname;
    }

    public void setLastname(@NotBlank(message = "El apellido es requerido") String lastname) {
        this.lastname = lastname;
    }

    public @NotBlank(message = "El email es requerido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "El email es requerido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "La contraseña es requerido") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "La contraseña es requerido") String password) {
        this.password = password;
    }

    public @NotBlank(message = "El telefono es requerido") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "El telefono es requerido") String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "El dirección es requerido") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "El dirección es requerido") String address) {
        this.address = address;
    }

    public @NotBlank(message = "La fecha de nacimiento es requerido") Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(@NotBlank(message = "La fecha de nacimiento es requerido") Date registrationdate) {
        this.registrationdate = registrationdate;
    }

    @NotBlank(message = "El estado es requerido")
    public int getState() {
        return state;
    }

    public void setState(@NotBlank(message = "El estado es requerido") int state) {
        this.state = state;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Ordr> getOrdrs() {
        return ordrs;
    }

    public void setOrdrs(Set<Ordr> ordrs) {
        this.ordrs = ordrs;
    }
}