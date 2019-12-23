package pers.javid.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import pers.javid.mall.service.IDemoService;
import pers.javid.mall.service.IDubboService;

@Service
public class DubboDemoServiceImpl implements IDemoService {
    @Reference(interfaceClass = IDubboService.class,check = false)
    private IDubboService iDubboService;

    @Override
    public String test() {
        return iDubboService.helloDubbo();
    }
}
