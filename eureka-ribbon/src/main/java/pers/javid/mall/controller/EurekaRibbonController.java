package pers.javid.mall.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("ribbon")
public class EurekaRibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/message")
    @HystrixCommand(fallbackMethod = "errorMethod")
    public String getMessage(){
        String message = restTemplate.getForObject("http://product-client/product/message",String.class);
        return message;
    }

    public String errorMethod(){
        return "it may be something wrong with the server";
    }
}
