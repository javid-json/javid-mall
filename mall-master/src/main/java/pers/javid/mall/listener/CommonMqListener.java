package pers.javid.mall.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import pers.javid.mall.entity.UserLog;

@Component
public class CommonMqListener {
    private final static Logger log = LoggerFactory.getLogger(CommonMqListener.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${log.user.queue.name}",containerFactory = "singleListenerContainer")
    public void consumerLogQueue(@Payload byte[] message){
        try {
            UserLog userLog = objectMapper.readValue(message,UserLog.class);
            log.info("监听到消息:{}",userLog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
