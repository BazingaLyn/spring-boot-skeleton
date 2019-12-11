package com.lyncc.bazinga.service;


import com.lyncc.bazinga.model.Order;

import java.util.List;

public interface OrderService {

    void save(Order o);

    void batchSave(List<Order> orders);

    Order findOrderByUserId(Integer userId);

    List<Order> findOrdersByUserIds(List<Integer> userIds);

}
