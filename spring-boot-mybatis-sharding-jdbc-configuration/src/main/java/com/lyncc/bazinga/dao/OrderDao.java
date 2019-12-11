package com.lyncc.bazinga.dao;

import com.lyncc.bazinga.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    Integer insert(Order order);


    Integer batchInsert(@Param("orders") List<Order> orders);


    Order findOrderByUseId(Integer userId);


    List<Order> findOrdersByIds(@Param("userIds") List<Integer> userIds);


}
