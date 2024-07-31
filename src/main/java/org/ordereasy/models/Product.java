package org.ordereasy.models;

import java.util.List;

public class Product {
    private int IdProduct;
    private String Name;
    private String Description;
    private Double Price;
    private String Category;
    private String Image1;
    private String Image2;
    private String Image3;

    private Restaurant restaurant;
    private Restaurant restaurants;
    private List<OrderDetail> orderDetails;

    public Product() {
    }

    public Product(int idProduct, String name, String description, Double price, String category, String image1, String image2, String image3, Restaurant restaurant) {
        IdProduct = idProduct;
        Name = name;
        Description = description;
        Price = price;
        Category = category;
        Image1 = image1;
        Image2 = image2;
        Image3 = image3;
        this.restaurant = restaurant;
    }

    public int getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(int idProduct) {
        IdProduct = idProduct;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getImage1() {
        return Image1;
    }

    public void setImage1(String image1) {
        Image1 = image1;
    }

    public String getImage2() {
        return Image2;
    }

    public void setImage2(String image2) {
        Image2 = image2;
    }

    public String getImage3() {
        return Image3;
    }

    public void setImage3(String image3) {
        Image3 = image3;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
