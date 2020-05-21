package com.fandp.service;

import com.fandp.domain.Product;
import com.fandp.service.fallback.ProductServiceFallBackFactory;
import com.fandp.service.fallback.ProductServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-07 16:05
 **/
//fallback用于指定容错类
@FeignClient(name="service-product",
        //fallback = ProductServiceFallback.class,
        fallbackFactory = ProductServiceFallBackFactory.class)
public interface ProductService {
    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid);
}
