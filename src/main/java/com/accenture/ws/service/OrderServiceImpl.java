package com.accenture.ws.service;

import com.accenture.ws.entity.*;
import com.accenture.ws.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CafeClerk clerk;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }



    public void saveOrder(Order order) {
        if (!order.getIsDiscounted()){
            order.setIsDiscountedPercentage(0.00);
        }
        if (order.getPrice() != null) {
            DecimalFormat df = new DecimalFormat("#.##");
            order.setPrice(Double.valueOf(df.format(order.getPrice())));
        }

        orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public void updateOrderById(Long id, Order order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            orderRepository.save(order);
        }
    }

    public OrderBill getTotalRegularBill() {
        RegularBill regularBill = new RegularBill(clerk);
        regularBill.setOrderList(orderRepository.findAll());
        return regularBill;
    }

    public OrderBill getTotalDiscountedBill() {
        DiscountedBill discountedBill = new DiscountedBill(clerk);
        discountedBill.setOrderList(orderRepository.findAll());
        return discountedBill;
    }
}