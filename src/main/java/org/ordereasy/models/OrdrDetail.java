package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Table(name = "ordrdetail")
@Entity
public class OrdrDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "La cantidad es requerida")
    @Column(name = "amount")
    private int amount;

    @NotNull(message = "El precio es requerido")
    @Column(name = "unitprice")
    private Double unitprice;

    @NotNull(message = "El total es requerido")
    @Column(name = "total")
    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordr_id", referencedColumnName = "id", nullable = false)
    private Ordr ordr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @NotNull(message = "El estado es requerido")
    @Column(name = "state")
    private Integer state;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Product> products;

    public OrdrDetail() {
    }

    public OrdrDetail(Integer id, int amount, Double unitPrice, Double total, Ordr ordr, Product product, Integer state) {
        this.id = id;
        this.amount = amount;
        this.unitprice = unitPrice;
        this.total = total;
        this.ordr = ordr;
        this.product = product;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount( int amount) {
        this.amount = amount;
    }
    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public  Double getTotal() {
        return total;
    }

    public void setTotal( Double total) {
        this.total = total;
    }

    public Ordr getOrdr() {
        return ordr;
    }

    public void setOrdr(Ordr ordr) {
        this.ordr = ordr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}