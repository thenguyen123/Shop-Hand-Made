package com.example.handmade.model;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  long id;
    private  int amount;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderProduct order;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private  Product product;

    public OrderDetail() {
    }

    public OrderDetail(long id, int amount, OrderProduct order, Product product) {
        this.id = id;
        this.amount = amount;
        this.order = order;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public OrderProduct getOrder() {
        return order;
    }

    public void setOrder(OrderProduct order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
