package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;


@Table(name = "ordrdetail")
@Entity
public class OrdrDetail {

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
    @JoinColumn(name = "ordr_id",nullable = false)
    private Ordr ordr;


    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Product> products;

    @NotNull(message = "El estado es requerido")
    @Column(name = "state")
    private Integer State;

    public OrdrDetail() {
    }

    public OrdrDetail(Integer id, int amount, Double unitPrice, Double total, Ordr ordr, Set<Product> products, Integer state) {
        this.id = id;
        Amount = amount;
        UnitPrice = unitPrice;
        Total = total;
        this.ordr = ordr;
        this.products = products;
        State = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank(message = "La cantidad es requerida")
    public int getAmount() {
        return Amount;
    }

    public void setAmount(@NotBlank(message = "La cantidad es requerida") int amount) {
        Amount = amount;
    }

    public @NotBlank(message = "El precio es requerido") Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(@NotBlank(message = "El precio es requerido") Double unitPrice) {
        UnitPrice = unitPrice;
    }

    public @NotBlank(message = "El total es requerido") Double getTotal() {
        return Total;
    }

    public void setTotal(@NotBlank(message = "El total es requerido") Double total) {
        Total = total;
    }

    public Ordr getOrdr() {
        return ordr;
    }

    public void setOrdr(Ordr ordr) {
        this.ordr = ordr;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public @NotNull(message = "El estado es requerido") Integer getState() {
        return State;
    }

    public void setState(@NotNull(message = "El estado es requerido") Integer state) {
        State = state;
    }
}
