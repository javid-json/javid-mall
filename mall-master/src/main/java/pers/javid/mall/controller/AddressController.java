package pers.javid.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.javid.mall.entity.Address;
import pers.javid.mall.service.AddressService;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/address")
    public int save(@RequestBody Address address){
        return addressService.insert(address);
    }

    @PutMapping(value = "/address")
    public int update(@RequestBody Address address){
        return addressService.updateByPrimaryKey(address);
    }

    @DeleteMapping(value = "/address/{id}")
    public int delete(@PathVariable(value = "id") Integer id){
        return addressService.deleteByPrimaryKey(id);
    }

    @GetMapping(value = "/address")
    public List<Address> getBy(
            @RequestParam(value = "userId",required = false) Integer userId){
        return addressService.getBy(userId);
    }
}
