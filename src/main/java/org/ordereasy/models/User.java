package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
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

    @NotBlank(message = "La contraseña es requerida")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "El teléfono es requerido")
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "La dirección es requerida")
    @Column(name = "address")
    private String address;

    @Column(name = "registrationdate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // Asegura el formato correcto en las solicitudes
    @NotNull(message = "La fecha de registro es requerida")
    private LocalDate registrationdate;

    @NotNull(message = "El estado es requerido")
    @Column(name = "state")
    private Integer state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Ordr> ordrs;

    // Constructor vacío
    public User() {}

    // Constructor con parámetros
    public User(Integer id, String name, String lastname, String email, String password, String address, String phone, LocalDate registrationdate, Integer state, Role role, Set<Ordr> ordrs) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.registrationdate = registrationdate;
        this.state = state;
        this.role = role;
        this.ordrs = ordrs;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(LocalDate registrationdate) {
        this.registrationdate = registrationdate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
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
