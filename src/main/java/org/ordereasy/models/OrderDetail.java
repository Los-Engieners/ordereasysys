package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;


@Table(name = "orderdetail")
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "La cantidad es requerida")
    @Column(name = "amount")
    private int Amount;

    @NotBlank(message = "El precio es requerido")
    @Column(name = "unitprice")
    private Double UnitPrice;

    @NotBlank(message = "El total es requerido")
    @Column(name = "total")
    private Double Total;



    @ManyToOne
    @JoinColumn(name = "orderid",nullable = false)
    private Order order;


    @OneToMany(mappedBy = "productid", cascade = CascadeType.ALL)
    private Set<Product> products;

    public OrderDetail() {
    }

    public OrderDetail(Integer id, int amount, Double unitPrice, Double total, Order order, Set<Product> products) {
        this.id = id;
        Amount = amount;
        UnitPrice = unitPrice;
        Total = total;
        this.order = order;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        UnitPrice = unitPrice;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
