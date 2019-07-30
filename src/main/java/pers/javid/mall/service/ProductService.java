package pers.javid.mall.service;

import pers.javid.mall.entity.Product;

public interface ProductService {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKey(Product record);
}
