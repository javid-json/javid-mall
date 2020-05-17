package pers.javid.mall.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pers.javid.mall.dao.UserMapper;
import pers.javid.mall.dto.CommonResult;
import pers.javid.mall.entity.User;

@Service
public class UserServiceImpl implements UserService{
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不对");
        }
        return user;
    }

    @Override
    public CommonResult register(User user){
        User data = userMapper.loadUserByUserName(user.getUserName());
        if(null != data){
            return new CommonResult().faild("用户已存在");
        }
        int result = userMapper.insert(user);
        if(result > 0){
            return new CommonResult().success();
        }else{
            return new CommonResult().faild();
        }
    }
}
