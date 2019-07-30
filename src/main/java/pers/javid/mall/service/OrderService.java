package pers.javid.mall.service;

import pers.javid.mall.entity.Order;

public interface OrderService {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKey(Order record);

}
