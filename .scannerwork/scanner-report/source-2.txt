package com.accenture.ws.controller;

import com.accenture.ws.entity.*;
import com.accenture.ws.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OrderAndBillingController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/orders")
    public List<Order> getOrderList() {
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @PutMapping("/update/{id}")
    public void updateOrderById(@PathVariable Long id, @RequestBody Order order) {
        orderService.updateOrderById(id, order);
    }

    @GetMapping("/totalRegularBill")
    public OrderBill getTotalRegularBill() {
        return orderService.getTotalRegularBill();
    }

    @GetMapping("/totalDiscountedBill")
    public OrderBill getTotalDiscountedBill() {
        return orderService.getTotalDiscountedBill();
    }
}