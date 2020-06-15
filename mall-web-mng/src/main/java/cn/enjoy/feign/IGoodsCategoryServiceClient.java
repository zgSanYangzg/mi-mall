package cn.enjoy.feign;

import cn.enjoy.mall.service.IGoodsCategoryService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MALL-PRODUCT-SERVICE")
public interface IGoodsCategoryServiceClient extends IGoodsCategoryService {
}
