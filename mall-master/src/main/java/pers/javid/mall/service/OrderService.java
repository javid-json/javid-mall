package pers.javid.mall.service;

import pers.javid.mall.entity.Order;

public interface OrderService {
    int deleteByPrimaryKey(Integer orderId);

    Object create(Order record);

    Object cancel(Integer orderId);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKey(Order record);

}
