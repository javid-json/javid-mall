package pers.javid.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

@RestController
@RequestMapping("product")
public class ProductController {
    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "reduceStock",method = RequestMethod.GET)
    public String reduceStock(){
        logger.info("库存减少数量：");
        return "库存减少数量：";
    }

    @GetMapping("/message")
    public String getMessage(){
        return "当前商品服务端口号为:"+port;
    }
}
