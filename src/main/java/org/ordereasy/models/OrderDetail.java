package org.ordereasy.models;

public class OrderDetail {
    private int IdOrderDetail;
    private int Amount;
    private Double UnitPrice;
    private Double Total;
    private Order order;
    private Product product;

    private Product products;

    public OrderDetail() {
    }

    public OrderDetail(int idOrderDetail, int amount, Double unitPrice, Double total, Order order, Product product) {
        IdOrderDetail = idOrderDetail;
        Amount = amount;
        UnitPrice = unitPrice;
        Total = total;
        this.order = order;
        this.product = product;
    }

    public int getIdOrderDetail() {
        return IdOrderDetail;
    }

    public void setIdOrderDetail(int idOrderDetail) {
        IdOrderDetail = idOrderDetail;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

