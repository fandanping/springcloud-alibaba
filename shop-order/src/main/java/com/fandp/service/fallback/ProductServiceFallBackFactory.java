package com.fandp.service.fallback;

import com.fandp.domain.Product;
import com.fandp.service.ProductService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 * @description:  容错类 ，要实现接口FallbackFactory<要为哪个接口产生容错类>
 *   可以有出错信息
 * @author: fandp
 * @create: 2020-05-09 09:42
 **/
@Service
public class ProductServiceFallBackFactory implements FallbackFactory<ProductService>{
    //Throwable 就是feign在调用过程中产生的异常
    @Override
    public ProductService create(Throwable throwable) {
        return new ProductService() {
            @Override
            public Product product(Integer pid) {
                throwable.printStackTrace();
                Product product =new Product();
                product.setPid(-100);
                return product;
            }
        };
    }
}
