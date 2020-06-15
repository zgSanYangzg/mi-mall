package cn.enjoy.mall.web.controller;

import cn.enjoy.core.utils.response.HttpResponseBody;
import cn.enjoy.mall.model.UserAddress;
import cn.enjoy.mall.service.IUserAddressService;
import cn.enjoy.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userAddress")
public class UserAddressController extends BaseController {
    @Autowired
    private IUserAddressService userAddressService;

    @PostMapping("save")
    public HttpResponseBody save(UserAddress userAddress){
        userAddress.setUserId(getSessionUserId());
        userAddressService.save(userAddress);
        return HttpResponseBody.successResponse("ok");
    }

    @PostMapping("remove")
    public HttpResponseBody remove(@RequestParam(name = "addressId", required = false) Integer addressId){
        userAddressService.remove(addressId);
        return HttpResponseBody.successResponse("ok");
    }

    @GetMapping("list")
    public HttpResponseBody list(){
        return HttpResponseBody.successResponse("ok",userAddressService.selectByUserId(getSessionUserId()));
    }

}
