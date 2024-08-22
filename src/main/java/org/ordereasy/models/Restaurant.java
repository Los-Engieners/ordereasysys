package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;


@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    @Column(name = "name")
    private String Name;

    @NotBlank(message = "La dirección es requerida")
    @Column(name = "address")
    private String Address;

    @NotBlank(message = "El telefono es requerida")
    @Column(name = "phone")
    private String Phone;

    @NotBlank(message = "El horario es requerido")
    @Column(name = "schedule")
    private String Schedule;

    @NotBlank(message = "La descripción es requerida")
    @Column(name = "descripcion")
    private String Description;

    @NotBlank(message = "La imagen es requerida")
    @Column(name = "image")
    private String Image;

    @NotBlank(message = "El Logo es requerido")
    @Column(name = "logo")
    private String Logo;

    @NotNull(message = "El estado es requerido")
    @Column(name = "state")
    private Integer State;


    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Ordr> ordrs;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Product> products;



    public Restaurant() {
    }

    public Restaurant(Integer id, String name, String address, String phone, String schedule, String description, String image, String logo, Integer state, Set<Ordr> ordrs, Set<Product> products) {
        this.id = id;
        Name = name;
        Address = address;
        Phone = phone;
        Schedule = schedule;
        Description = description;
        Image = image;
        Logo = logo;
        State = state;
        this.ordrs = ordrs;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es requerido") String getName() {
        return Name;
    }

    public void setName(@NotBlank(message = "El nombre es requerido") String name) {
        Name = name;
    }

    public @NotBlank(message = "La dirección es requerida") String getAddress() {
        return Address;
    }

    public void setAddress(@NotBlank(message = "La dirección es requerida") String address) {
        Address = address;
    }

    public @NotBlank(message = "El telefono es requerida") String getPhone() {
        return Phone;
    }

    public void setPhone(@NotBlank(message = "El telefono es requerida") String phone) {
        Phone = phone;
    }

    public @NotBlank(message = "El horario es requerido") String getSchedule() {
        return Schedule;
    }

    public void setSchedule(@NotBlank(message = "El horario es requerido") String schedule) {
        Schedule = schedule;
    }

    public @NotBlank(message = "La descripción es requerida") String getDescription() {
        return Description;
    }

    public void setDescription(@NotBlank(message = "La descripción es requerida") String description) {
        Description = description;
    }

    public @NotBlank(message = "La imagen es requerida") String getImage() {
        return Image;
    }

    public void setImage(@NotBlank(message = "La imagen es requerida") String image) {
        Image = image;
    }

    public @NotBlank(message = "El Logo es requerido") String getLogo() {
        return Logo;
    }

    public void setLogo(@NotBlank(message = "El Logo es requerido") String logo) {
        Logo = logo;
    }

    public @NotNull(message = "El estado es requerido") Integer getState() {
        return State;
    }

    public void setState(@NotNull(message = "El estado es requerido") Integer state) {
        State = state;
    }

    public Set<Ordr> getOrdrs() {
        return ordrs;
    }

    public void setOrdrs(Set<Ordr> ordrs) {
        this.ordrs = ordrs;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
