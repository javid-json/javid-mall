package pers.javid.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.javid.mall.dao.ProductMapper;
import pers.javid.mall.entity.Product;
import pers.javid.mall.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public int deleteByPrimaryKey(Integer productId) {
        return productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public Product selectByPrimaryKey(Integer productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }
}
