package pers.javid.mall.service;

import pers.javid.mall.entity.User;

public interface UserService {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKey(User record);
}
