package org.ordereasy.models;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


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

    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser mayor que cero")
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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)
    private Restaurant restaurant;

    @NotNull(message = "El estado es requerido")
    @Column(name = "state")
    private Integer State;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<OrdrDetail> ordrDetails;

    public Product() {
    }

    public Product(Integer id, String description, String name, Double price, String category, String image1, String image2, String image3, Restaurant restaurant, Integer state, Set<OrdrDetail> ordrDetails) {
        this.id = id;
        Description = description;
        Name = name;
        Price = price;
        Category = category;
        Image1 = image1;
        Image2 = image2;
        Image3 = image3;
        this.restaurant = restaurant;
        State = state;
        this.ordrDetails = ordrDetails;
    }

    public @NotBlank(message = "La descripción es requerida") String getDescription() {
        return Description;
    }

    public void setDescription(@NotBlank(message = "La descripción es requerida") String description) {
        Description = description;
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

    public  Double getPrice() {
        return Price;
    }

    public void setPrice( Double price) {
        Price = price;
    }

    public @NotBlank(message = "La categoria es requerida") String getCategory() {
        return Category;
    }

    public void setCategory(@NotBlank(message = "La categoria es requerida") String category) {
        Category = category;
    }

    public @NotBlank(message = "La imagen es requerida") String getImage1() {
        return Image1;
    }

    public void setImage1(@NotBlank(message = "La imagen es requerida") String image1) {
        Image1 = image1;
    }

    public @NotBlank(message = "La imagen es requerida") String getImage2() {
        return Image2;
    }

    public void setImage2(@NotBlank(message = "La imagen es requerida") String image2) {
        Image2 = image2;
    }

    public @NotBlank(message = "La imagen es requerida") String getImage3() {
        return Image3;
    }

    public void setImage3(@NotBlank(message = "La imagen es requerida") String image3) {
        Image3 = image3;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public @NotNull(message = "El estado es requerido") Integer getState() {
        return State;
    }

    public void setState(@NotNull(message = "El estado es requerido") Integer state) {
        State = state;
    }

    public Set<OrdrDetail> getOrdrDetails() {
        return ordrDetails;
    }

    public void setOrdrDetails(Set<OrdrDetail> ordrDetails) {
        this.ordrDetails = ordrDetails;
    }
}
