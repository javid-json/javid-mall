package pers.javid.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.javid.mall.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public int createOrder() {
        return 1;
    }
}
