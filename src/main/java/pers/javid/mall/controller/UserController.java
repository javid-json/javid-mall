package pers.javid.mall.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import pers.javid.mall.entity.Address;
import pers.javid.mall.entity.User;
import pers.javid.mall.entity.UserLog;
import pers.javid.mall.service.UserService;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/user")
    public int save(@RequestBody User user){
        return userService.insert(user);
    }

    @PutMapping(value = "/user")
    public int update(@RequestBody User user){
        return userService.updateByPrimaryKey(user);
    }

    @DeleteMapping(value = "/user/{id}")
    public int delete(@PathVariable(value = "id") Integer id){
        return userService.deleteByPrimaryKey(id);
    }

    @GetMapping(value = "/user/login")
    public String login(
            @RequestParam(value = "userName",required = false) String userName,
            @RequestParam(value = "password",required = false) String password){
        String result = "login success";
        UserLog userLog = new UserLog(userName,"login","userData");
        userLog.setCreateTime(new Date());
        try{
            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
            rabbitTemplate.setExchange(env.getProperty("log.user.exchange.name"));
            rabbitTemplate.setRoutingKey(env.getProperty("log.user.routing.key.name"));
            Message message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(userLog)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
            message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, MessageProperties.CONTENT_TYPE_JSON);
            rabbitTemplate.convertAndSend(message);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value="/user/test")
    public void loginTest(@RequestParam(value = "userName",required = false) String userName){
        log.info("当前用户:",userName);
    }
}
