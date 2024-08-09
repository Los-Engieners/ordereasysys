package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
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

    @NotBlank(message = "La dirección es requerido")
    @Column(name = "adress")
    private String Address;
    @NotBlank(message = "El telefono es requerido")
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


    @OneToMany(mappedBy = "orderid", cascade = CascadeType.ALL)
    private Set<Order> orders;

    @OneToMany(mappedBy = "productid", cascade = CascadeType.ALL)
    private Set<Product> products;



    public Restaurant() {
    }

    public Restaurant(Integer id, String name, String address, String schedule, String phone, String description, String image, String logo, Set<Product> products) {
        this.id = id;
        Name = name;
        Address = address;
        Schedule = schedule;
        Phone = phone;
        Description = description;
        Image = image;
        Logo = logo;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName( String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress( String address) {
        Address = address;
    }

    public  String getPhone() {
        return Phone;
    }

    public void setPhone( String phone) {
        Phone = phone;
    }

    public  String getSchedule() {
        return Schedule;
    }

    public void setSchedule( String schedule) {
        Schedule = schedule;
    }

    public  String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public  String getDescription() {
        return Description;
    }

    public void setDescription( String description) {
        Description = description;
    }

    public  String getLogo() {
        return Logo;
    }

    public void setLogo( String logo) {
        Logo = logo;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
