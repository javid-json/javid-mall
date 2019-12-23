package pers.javid.mall.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import pers.javid.mall.dto.CommonResult;
import pers.javid.mall.entity.User;
import pers.javid.mall.entity.UserLog;
import pers.javid.mall.service.UserService;

import java.util.Date;

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
    public Object login(
            @RequestParam(value = "userName",required = false) String userName,
            @RequestParam(value = "password",required = false) String password){
        User user = (User) userService.loadUserByUsername(userName);
        if(null != user){
            UserLog userLog = new UserLog(user.getUserName(),"login","userData");
            userLog.setCreateTime(new Date());
//            try{
//                rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//                rabbitTemplate.setExchange(env.getProperty("log.user.exchange.name"));
//                rabbitTemplate.setRoutingKey(env.getProperty("log.user.routing.key.name"));
//                Message message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(userLog)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
//                message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, MessageProperties.CONTENT_TYPE_JSON);
//                rabbitTemplate.convertAndSend(message);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
            log.info("当前用户"+user.getUserName());
        }else{
            return new CommonResult().faild("用户不存在");
        }
        return new CommonResult().success(user);
    }

    @PostMapping(value = "/user/register")
    public Object register(@RequestBody User user){
        return userService.register(user);
    }

    @GetMapping(value="/user/test")
    public String test(@RequestParam(value = "te",required = false) String test){
        return "test";
    }
}
