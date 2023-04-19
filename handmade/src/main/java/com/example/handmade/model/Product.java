package com.example.handmade.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String name;
    private double prices;
    @Column(columnDefinition = "text")
    private  String description;
    @Column(columnDefinition = "date")
    private String dateSubmitted;

    private int quantity;
    @ManyToOne
    @JoinColumn(name = "type_product", referencedColumnName = "id")
    private Types types;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<Image> image;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<OrderDetail> orderDetailSet;

    public Product(long id, String name, double prices, String description, String dateSubmitted, int quantity, Types types, Set<Image> image, Set<OrderDetail> orderDetailSet, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.prices = prices;
        this.description = description;
        this.dateSubmitted = dateSubmitted;
        this.quantity = quantity;
        this.types = types;
        this.image = image;
        this.orderDetailSet = orderDetailSet;
        this.isDelete = isDelete;
    }

    public Product() {
    }
    private boolean isDelete;

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }


    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }


    public Set<Image> getImage() {
        return image;
    }

    public void setImage(Set<Image> image) {
        this.image = image;
    }
}
