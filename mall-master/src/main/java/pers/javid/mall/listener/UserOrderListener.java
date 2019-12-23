package pers.javid.mall.listener;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component("userOrderListener")
public class UserOrderListener implements ChannelAwareMessageListener {
    private final static Logger log = LoggerFactory.getLogger(UserOrderListener.class);
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        String mobile = new String(body,"utf-8");
        log.info("监听到手机号:",mobile);
    }

}
