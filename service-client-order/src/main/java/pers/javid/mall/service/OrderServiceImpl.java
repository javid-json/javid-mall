package pers.javid.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.javid.mall.clients.ProductClient;
import pers.javid.mall.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductClient productClient;

    @Override
    public String createOrder() {

        return productClient.reduceStock();
    }
}
