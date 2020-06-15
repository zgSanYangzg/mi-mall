package cn.enjoy.feign;

import cn.enjoy.mall.service.manage.IAttributeManageService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MALL-PRODUCT-SERVICE")
public interface IAttributeManageServiceClient extends IAttributeManageService {
}
