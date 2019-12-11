package com.lyncc.bazinga.controller;

import com.lyncc.bazinga.model.Order;
import com.lyncc.bazinga.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {


    @Autowired
    private OrderService orderService;


    @PostMapping("/save")
    public String save(@RequestBody Order o) {
        for (int i = 0; i < 500; i++) {
            o.setUserId(i);
            orderService.save(o);
        }
        return "ok";
    }


    @GetMapping("/get/order/{userId}")
    public Order findOrderByUserId(@PathVariable Integer userId){
        return orderService.findOrderByUserId(userId);
    }


    @PostMapping("/get/ordersByUserIds")
    public List<Order> findOrdersByIds(@RequestBody List<Integer> userIds){
        return orderService.findOrdersByUserIds(userIds);
    }


    @PostMapping("/batchSave")
    public String batchSave(@RequestBody Order o) {
        List<Order> orders = new ArrayList<>();
        for (int i = 1000; i < 1020; i++) {
            Order copy = new Order();
            copy.setUserId(i);
            copy.setAmount(o.getAmount());
            copy.setProductId(o.getProductId());
            copy.setProductName(o.getProductName());
            orders.add(copy);
        }
        orderService.batchSave(orders);
        return "batch ok";
    }
}
