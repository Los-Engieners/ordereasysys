package org.ordereasy.models;

import java.util.List;

public class Restaurant {
    private int IdRestaurant;
    private String Name;
    private String Address;
    private String Phone;
    private String Schedule;
    private String Description;
    private String Image;
    private String Logo;

    private List<Product> products;


    public Restaurant() {
    }

    public Restaurant(int idRestaurant, String name, String address, String phone, String schedule, String description, String image, String logo) {
        IdRestaurant = idRestaurant;
        Name = name;
        Address = address;
        Phone = phone;
        Schedule = schedule;
        Description = description;
        Image = image;
        Logo = logo;
    }

    public int getIdRestaurant() {
        return IdRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        IdRestaurant = idRestaurant;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getSchedule() {
        return Schedule;
    }

    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }
}
