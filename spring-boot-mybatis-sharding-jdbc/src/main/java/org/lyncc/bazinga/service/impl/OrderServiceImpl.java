package org.lyncc.bazinga.service.impl;

import org.lyncc.bazinga.dao.OrderDao;
import org.lyncc.bazinga.model.Order;
import org.lyncc.bazinga.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {


    @Resource
    private OrderDao orderDao;

    @Override
    public void save(Order o) {
        orderDao.insert(o);
    }
}
