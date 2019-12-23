package pers.javid.mall.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.javid.mall.entity.Order;
import pers.javid.mall.service.OrderService;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order/create")
    public Object create(@RequestBody Order order){
        return orderService.create(order);
    }

    @PutMapping("/order/cancel/{orderId}")
    public Object cancel(@PathVariable("orderId") Integer orderId){
        return orderService.cancel(orderId);
    }

}
