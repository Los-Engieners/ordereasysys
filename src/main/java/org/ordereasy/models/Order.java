package org.ordereasy.models;

import java.util.List;

public class Order {
    private int IdOrder;
    private String OrderDate;
    private String DeliveryTime;
    private String State;
    private Double Total;
    private User user;

    private Restaurant restaurant;
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(int idOrder, String orderDate, String deliveryTime, String state, Double total, User user, Restaurant restaurant) {
        IdOrder = idOrder;
        OrderDate = orderDate;
        DeliveryTime = deliveryTime;
        State = state;
        Total = total;
        this.user = user;
        this.restaurant = restaurant;
    }

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int idOrder) {
        IdOrder = idOrder;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getDeliveryTime() {
        return DeliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        DeliveryTime = deliveryTime;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
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
}
