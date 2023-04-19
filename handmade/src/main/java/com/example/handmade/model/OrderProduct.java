package com.example.handmade.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codeOrder;
    @Column(columnDefinition = "date")
    private String datePurchase;
    private double totalPay;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Set<OrderDetail> orderDetailSet;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private AppUser appUser;

    public OrderProduct() {
    }

    public OrderProduct(long id, String codeOrder, String datePurchase, double totalPay, Set<OrderDetail> orderDetailSet, AppUser appUser) {
        this.id = id;
        this.codeOrder = codeOrder;
        this.datePurchase = datePurchase;
        this.totalPay = totalPay;
        this.orderDetailSet = orderDetailSet;
        this.appUser = appUser;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(String codeOrder) {
        this.codeOrder = codeOrder;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }
}
