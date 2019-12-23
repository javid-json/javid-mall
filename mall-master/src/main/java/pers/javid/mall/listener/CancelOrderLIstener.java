package pers.javid.mall.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.javid.mall.service.OrderService;

/**
 * @author ：javid
 * @date ：Created in 2019-8-21
 * @description：取消订单消费者
 * @version: 1.0
 */
@Component
@RabbitListener(queues = "mall.order.cancel.ttl")
public class CancelOrderLIstener {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderLIstener.class);
    @Autowired
    private OrderService orderService;

    @RabbitHandler
    public void handel(Integer orderId){
        LOGGER.info("订单消费成功");
        orderService.cancel(orderId);
    }
}
