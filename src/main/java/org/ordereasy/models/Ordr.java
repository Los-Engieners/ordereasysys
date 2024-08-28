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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "La fecha de orden es requerida")
    @Column(name = "orderdate")
    private LocalDate orderdate;

    @NotBlank(message = "El tiempo de entrega es requerido")
    @Column(name = "deliverytime")
    private String deliverytime;

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

    public Ordr(Integer id, LocalDate ordrdate, String deliverytime, String state, Double total, User user, Restaurant restaurant, Integer estate, Set<OrdrDetail> ordrDetails) {
        this.id = id;
        this.orderdate = ordrdate;
        this.deliverytime = deliverytime;
        this.state = state;
        this.total = total;
        this.user = user;
        this.restaurant = restaurant;
        this.estate = estate;
        this.ordrDetails = ordrDetails;
    }

    public  LocalDate getOrdrdate() {
        return orderdate;
    }

    public void setOrdrdate(LocalDate ordrdate) {
        this.orderdate = ordrdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public  String getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(String deliverytime) {
        this.deliverytime = deliverytime;
    }

    public  String getState() {
        return state;
    }

    public void setState( String state) {
        this.state = state;
    }

    public  Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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

    public  Integer getEstate() {
        return estate;
    }

    public void setEstate(Integer estate) {
        this.estate = estate;
    }

    public Set<OrdrDetail> getOrdrDetails() {
        return ordrDetails;
    }

    public void setOrdrDetails(Set<OrdrDetail> ordrDetails) {
        this.ordrDetails = ordrDetails;
    }
}