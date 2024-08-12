package org.ordereasy.models;
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
    @Column(name = "name")
    private String Name;

    @NotBlank(message = "La descripción es requerida")
    @Column(name = "description")
    private String Description;

    @NotBlank(message = "El precio es requerido")
    @Column(name = "price")
    private Double Price;

    @NotBlank(message = "La categoria es requerida")
    @Column(name = "category")
    private String Category;

    @NotBlank(message = "La imagen es requerida")
    @Column(name = "image1")
    private String Image1;

    @NotBlank(message = "La imagen es requerida")
    @Column(name = "image2")
    private String Image2;

    @NotBlank(message = "La imagen es requerida")
    @Column(name = "image3")
    private String Image3;


    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<OrdrDetail> ordrDetails;

    public Product() {
    }


    public Product(Integer id, String name, String description, Double price, String category, String image1, String image2, String image3, Restaurant restaurant, Set<OrdrDetail> ordrDetails) {
        this.id = id;
        Name = name;
        Description = description;
        Price = price;
        Category = category;
        Image1 = image1;
        Image2 = image2;
        Image3 = image3;
        this.restaurant = restaurant;
        this.ordrDetails = ordrDetails;
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

    public Set<OrdrDetail> getOrderDetails() {
        return ordrDetails;
    }

    public void setOrderDetails(Set<OrdrDetail> ordrDetails) {
        this.ordrDetails = ordrDetails;
    }
}
