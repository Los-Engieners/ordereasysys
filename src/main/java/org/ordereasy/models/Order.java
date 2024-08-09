package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Set;


@Table(name = "order")
@Entity
public class Order {

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



    @OneToMany(mappedBy = "orderdetail", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;



    @ManyToOne
    @JoinColumn(name = "userid",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurantid",nullable = false)
    private Restaurant restaurant;




    public Order() {
    }

    public Order(Integer id, String orderDate, String deliveryTime, String state, Double total, User user, Restaurant restaurant, Set<OrderDetail> orderDetails) {
        this.id = id;
        OrderDate = orderDate;
        DeliveryTime = deliveryTime;
        State = state;
        Total = total;
        this.user = user;
        this.restaurant = restaurant;
        this.orderDetails = orderDetails;
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

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
