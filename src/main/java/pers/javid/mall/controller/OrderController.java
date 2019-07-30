package pers.javid.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pers.javid.mall.service.OrderService;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

}
