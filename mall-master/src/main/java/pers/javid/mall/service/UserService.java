package pers.javid.mall.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pers.javid.mall.dto.CommonResult;
import pers.javid.mall.entity.User;

public interface UserService extends UserDetailsService {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKey(User record);

    CommonResult register(User user);
}
