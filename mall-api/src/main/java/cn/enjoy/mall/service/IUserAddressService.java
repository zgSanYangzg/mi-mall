package cn.enjoy.mall.service;

import cn.enjoy.mall.model.UserAddress;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/mall/service/IUserAddressService")
public interface IUserAddressService {
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    void save(@RequestBody UserAddress userAddress);

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    void remove(@RequestParam("addressId") Integer addressId);

    @RequestMapping(value = "/selectByUserId", method = RequestMethod.POST)
    List<UserAddress> selectByUserId(@RequestParam("userId") String userId);
}
