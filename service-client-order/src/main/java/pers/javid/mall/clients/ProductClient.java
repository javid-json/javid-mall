package pers.javid.mall.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import org.springframework.cloud.openfeign.FeignClient;
@Component
@FeignClient("product-client")
public interface ProductClient {
    @RequestMapping(value = "/product/reduceStock",method = RequestMethod.GET)
    String reduceStock();
}
