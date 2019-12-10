package org.lyncc.bazinga.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lyncc.bazinga.model.Order;

@Mapper
public interface OrderDao {

    Integer insert(Order order);
}
