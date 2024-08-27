package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;

@Table(name = "ordr")
@Entity
public class Ordr {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "La fecha de orden es requerida")
    @Column(name = "orderdate")
    private LocalDate ordrDate;

    @NotBlank(message = "El tiempo de entrega es requerido")
    @Column(name = "deliverytime")
    private String deliveryTime;

    @NotBlank(message = "El estado es requerido")
    @Column(name = "state")
    private String state;

    @NotNull(message = "El total es requerido")
    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @NotNull(message = "El estado es requerido")
    @Column(name = "estate")
    private Integer estate;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<OrdrDetail> ordrDetails;
    public Ordr() {
    }

    public Ordr(Integer id, LocalDate ordrDate, String deliveryTime, String state, Double total, Set<OrdrDetail> ordrDetails, User user, Restaurant restaurant, Integer estate) {
        this.id = id;
        this.ordrDate = ordrDate;
        this.deliveryTime = deliveryTime;
        this.state = state;
        this.total = total;
        this.ordrDetails = ordrDetails;
        this.user = user;
        this.restaurant = restaurant;
        this.estate = estate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return ordrDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.ordrDate = orderDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<OrdrDetail> getOrderDetails() {
        return ordrDetails;
    }

    public void setOrderDetails(Set<OrdrDetail> orderDetails) {
        this.ordrDetails = orderDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getEstate() {
        return estate;
    }

    public void setEstate(Integer estate) {
        this.estate = estate;
    }
}