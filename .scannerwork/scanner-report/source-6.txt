package com.accenture.ws.entity;

import java.util.List;

public class OrderBill {
    private List<Order> orderList;
    private CafeClerk clerk;

    public OrderBill(CafeClerk clerk) {
        this.clerk = clerk;
    }

    public CafeClerk getClerk() {
        return clerk;
    }

    public void setClerk(CafeClerk clerk) {
        this.clerk = clerk;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Double getTotalBill(){
        Double totalBill = 0.0;
        for (Order order : orderList) {
            totalBill += order.getPrice();
        }
        return totalBill;
    }
}
