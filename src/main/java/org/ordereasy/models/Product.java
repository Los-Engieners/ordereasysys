package org.ordereasy.models;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;



@Table(name = "product")
@Entity

public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotBlank(message = "El nombre es requerido")
    private String Name;

    @NotBlank(message = "La descripción es requerida")
    private String Description;

    @NotBlank(message = "El precio es requerido")
    private Double Price;

    @NotBlank(message = "La categoria es requerida")
    private String Category;

    @NotBlank(message = "La imagen es requerida")
    private String Image1;

    @NotBlank(message = "La imagen es requerida")
    private String Image2;

    @NotBlank(message = "La imagen es requerida")
    private String Image3;


    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;

    public Product() {
    }


    public Product(Integer id, String name, String description, Double price, String category, String image1, String image2, String image3, Restaurant restaurant, Set<OrderDetail> orderDetails) {
        this.id = id;
        Name = name;
        Description = description;
        Price = price;
        Category = category;
        Image1 = image1;
        Image2 = image2;
        Image3 = image3;
        this.restaurant = restaurant;
        this.orderDetails = orderDetails;
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

    public  String getDescription() {
        return Description;
    }

    public void setDescription( String description) {
        Description = description;
    }

    public  Double getPrice() {
        return Price;
    }

    public void setPrice( Double price) {
        Price = price;
    }

    public  String getCategory() {
        return Category;
    }

    public void setCategory( String category) {
        Category = category;
    }

    public String getImage1() {
        return Image1;
    }

    public void setImage1( String image1) {
        Image1 = image1;
    }

    public  String getImage2() {
        return Image2;
    }

    public void setImage2( String image2) {
        Image2 = image2;
    }

    public  String getImage3() {
        return Image3;
    }

    public void setImage3( String image3) {
        Image3 = image3;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
