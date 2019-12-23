package pers.javid.mall.service;

import pers.javid.mall.entity.Address;

import java.util.List;

public interface AddressService {
    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> getBy(Integer userId);
}
