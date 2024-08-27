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
    private Double unitPrice;

    @NotNull(message = "El total es requerido")
    @Column(name = "total")
    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordr_id", referencedColumnName = "id", nullable = false)
    private Ordr ordr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product  product;

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
        this.unitPrice = unitPrice;
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

    @NotNull(message = "La cantidad es requerida")
    public int getAmount() {
        return amount;
    }

    public void setAmount(@NotNull(message = "La cantidad es requerida") int amount) {
        this.amount = amount;
    }

    public @NotNull(message = "El precio es requerido") Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(@NotNull(message = "El precio es requerido") Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public @NotNull(message = "El total es requerido") Double getTotal() {
        return total;
    }

    public void setTotal(@NotNull(message = "El total es requerido") Double total) {
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

    public @NotNull(message = "El estado es requerido") Integer getState() {
        return state;
    }

    public void setState(@NotNull(message = "El estado es requerido") Integer state) {
        this.state = state;
    }
}