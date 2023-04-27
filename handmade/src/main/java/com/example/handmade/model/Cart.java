package com.example.handmade.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "date")
    private String datePurchase;
    private double totalPay;

    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    private Set<CartDetail> orderDetailSet;
    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private AppUser appUser;

    public Cart() {
    }

    public Cart(long id, String codeOrder, String datePurchase, double totalPay, Set<CartDetail> orderDetailSet, AppUser appUser) {
        this.id = id;
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

    public Set<CartDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<CartDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }
}
