package org.lyncc.bazinga.controller;

import org.lyncc.bazinga.model.Order;
import org.lyncc.bazinga.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "hello";
    }
}
