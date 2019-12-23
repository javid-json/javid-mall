package pers.javid.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.javid.mall.service.IDemoService;

@RestController
public class DubboDemoController {
    @Autowired
    private IDemoService iDemoService;

    @GetMapping(value="/dubbo")
    public String test(){
        return iDemoService.test();
    }
}
