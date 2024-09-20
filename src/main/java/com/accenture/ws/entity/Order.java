package com.accenture.ws.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderName;
    private Double price;
    private Boolean isDiscounted;
    private Double isDiscountedPercentage = 5.00;

    public Order() {
    }

    public Order(Long id, String orderName, Double price, Boolean isDiscounted, Double isDiscountedPercentage) {
        this.id = id;
        this.orderName = orderName;
        this.price = price;
        this.isDiscounted = isDiscounted;
        this.isDiscountedPercentage = isDiscountedPercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIsDiscounted() {
        return isDiscounted;
    }

    public void setIsDiscounted(Boolean IsDiscounted) {
        this.isDiscounted = IsDiscounted;
    }

    public Double getIsDiscountedPercentage() {
        return isDiscountedPercentage;
    }

    public void setIsDiscountedPercentage(Double isDiscountedPercentage) {
        this.isDiscountedPercentage = isDiscountedPercentage;
    }
}
