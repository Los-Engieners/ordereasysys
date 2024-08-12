package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

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




    public Ordr() {
    }

    public Ordr(Integer id, String orderDate, String deliveryTime, String state, Double total, User user, Restaurant restaurant, Set<OrdrDetail> ordrDetails) {
        this.id = id;
        OrderDate = orderDate;
        DeliveryTime = deliveryTime;
        State = state;
        Total = total;
        this.user = user;
        this.restaurant = restaurant;
        this.ordrDetails = ordrDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public  String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate( String orderDate) {
        OrderDate = orderDate;
    }

    public String getDeliveryTime() {
        return DeliveryTime;
    }

    public void setDeliveryTime( String deliveryTime) {
        DeliveryTime = deliveryTime;
    }

    public  String getState() {
        return State;
    }

    public void setState( String state) {
        State = state;
    }

    public  Double getTotal() {
        return Total;
    }

    public void setTotal( Double total) {
        Total = total;
    }

    public  User getUser() {
        return user;
    }

    public void setUser( User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<OrdrDetail> getOrdrDetails() {
        return ordrDetails;
    }

    public void setOrdrDetails(Set<OrdrDetail> ordrDetails) {
        this.ordrDetails = ordrDetails;
    }
}
