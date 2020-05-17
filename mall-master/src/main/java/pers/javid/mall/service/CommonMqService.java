package pers.javid.mall.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CommonMqService {
    private final static Logger log = LoggerFactory.getLogger(CommonMqService.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Environment env;

    public void sendingMsg(String mobile){
        try {
            rabbitTemplate.setRoutingKey(env.getProperty("user.order.routing.key.name"));
            rabbitTemplate.setExchange(env.getProperty("user.order.exchange.name"));
            Message messsage = MessageBuilder.withBody(mobile.getBytes("utf-8")).setDeliveryMode(MessageDeliveryMode.PERSISTENT.PERSISTENT).build();
            rabbitTemplate.send(messsage);
        }catch (Exception e){
            log.error("抢单发生异常：mobile{}:"+mobile);
        }
    }
}
