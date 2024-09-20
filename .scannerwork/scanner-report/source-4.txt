package com.accenture.ws.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class DiscountedBill extends OrderBill {

    public DiscountedBill(CafeClerk clerk) {
        super(clerk);
    }

    @Override
    public Double getTotalBill() {
        BigDecimal totalBill = BigDecimal.ZERO;


        for (Order order : getOrderList()) {

            BigDecimal price = BigDecimal.valueOf(order.getPrice());
            if (order.getIsDiscounted()) {
                BigDecimal discountPercentage = BigDecimal.valueOf(order.getIsDiscountedPercentage()).divide(new BigDecimal(100));
                BigDecimal discountedPrice = price.multiply(BigDecimal.ONE.subtract(discountPercentage));
                totalBill = totalBill.add(discountedPrice);
            } else {
                totalBill = totalBill.add(price);
            }
        }
        BigDecimal roundedTotalBill = totalBill.setScale(2, RoundingMode.HALF_UP);

        // Convert the rounded total bill to double and return
        return roundedTotalBill.doubleValue();
    }
}