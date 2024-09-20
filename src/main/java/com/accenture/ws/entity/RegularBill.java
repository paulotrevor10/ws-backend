package com.accenture.ws.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RegularBill extends OrderBill {

    public RegularBill(CafeClerk clerk) {
        super(clerk);
    }

    @Override
    public Double getTotalBill() {
        BigDecimal totalBill = BigDecimal.ZERO;
        for (Order order : getOrderList()) {
            BigDecimal price = BigDecimal.valueOf(order.getPrice());
            totalBill = totalBill.add(price);
        }
        BigDecimal roundedTotalBill = totalBill.setScale(2, RoundingMode.HALF_UP);
        return roundedTotalBill.doubleValue();
    }
}