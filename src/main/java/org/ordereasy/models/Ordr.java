package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;


@Table(name = "ordr")
@Entity
public class Ordr {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "La fecha de orden es requerida")
    @Column(name = "orderdate")
    private String OrderDate;

    @NotBlank(message = "El tiempo de entrega es requerido")
    @Column(name = "deliverytime")
    private String DeliveryTime;

    @NotBlank(message = "El estado es requerido")
    @Column(name = "state")
    private String State;

    @NotBlank(message = "El total es requerido")
    @Column(name = "total")
    private Double Total;

    @OneToMany(mappedBy = "ordr", cascade = CascadeType.ALL)
    private Set<OrdrDetail> ordrDetails;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id",nullable = false)
    private Restaurant restaurant;

    @NotNull(message = "El estado es requerido")
    @Column(name = "estate")
    private Integer Estate;




    public Ordr() {
    }

    public Ordr(Integer id, String deliveryTime, String orderDate, String state, Double total, Set<OrdrDetail> ordrDetails, User user, Restaurant restaurant, Integer estate) {
        this.id = id;
        DeliveryTime = deliveryTime;
        OrderDate = orderDate;
        State = state;
        Total = total;
        this.ordrDetails = ordrDetails;
        this.user = user;
        this.restaurant = restaurant;
        Estate = estate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "La fecha de orden es requerida") String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(@NotBlank(message = "La fecha de orden es requerida") String orderDate) {
        OrderDate = orderDate;
    }

    public @NotBlank(message = "El tiempo de entrega es requerido") String getDeliveryTime() {
        return DeliveryTime;
    }

    public void setDeliveryTime(@NotBlank(message = "El tiempo de entrega es requerido") String deliveryTime) {
        DeliveryTime = deliveryTime;
    }

    public @NotBlank(message = "El estado es requerido") String getState() {
        return State;
    }

    public void setState(@NotBlank(message = "El estado es requerido") String state) {
        State = state;
    }

    public @NotBlank(message = "El total es requerido") Double getTotal() {
        return Total;
    }

    public void setTotal(@NotBlank(message = "El total es requerido") Double total) {
        Total = total;
    }

    public Set<OrdrDetail> getOrdrDetails() {
        return ordrDetails;
    }

    public void setOrdrDetails(Set<OrdrDetail> ordrDetails) {
        this.ordrDetails = ordrDetails;
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

    public @NotNull(message = "El estado es requerido") Integer getEstate() {
        return Estate;
    }

    public void setEstate(@NotNull(message = "El estado es requerido") Integer estate) {
        Estate = estate;
    }
}
