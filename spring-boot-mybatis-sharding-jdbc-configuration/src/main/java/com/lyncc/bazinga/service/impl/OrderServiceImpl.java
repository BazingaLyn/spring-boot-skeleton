package com.lyncc.bazinga.service.impl;

import com.lyncc.bazinga.dao.OrderDao;
import com.lyncc.bazinga.model.Order;
import com.lyncc.bazinga.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Resource
    private OrderDao orderDao;

    @Override
    public void save(Order o) {
        orderDao.insert(o);
    }

    @Override
    public void batchSave(List<Order> orders) {
        orderDao.batchInsert(orders);
    }

    @Override
    public Order findOrderByUserId(Integer userId) {
        return orderDao.findOrderByUseId(userId);
    }

    @Override
    public List<Order> findOrdersByUserIds(List<Integer> userIds) {
        return orderDao.findOrdersByIds(userIds);
    }
}
