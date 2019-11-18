package pers.javid.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import pers.javid.mall.service.IDubboService;

@Service
public class DubboServiceImpl implements IDubboService {

    @Override
    public String helloDubbo() {
        return "hello dubbo , i am server";
    }

}
