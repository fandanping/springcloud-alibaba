package com.fandp.service.fallback;

import com.fandp.domain.Product;
import com.fandp.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @description: feign 容错类 ,需要实现feign所在的接口，并去实现接口中的所有方法。
 * 一旦feign远程调用出现问题了，就会进入当前类中同名方法，执行容错逻辑。
 * 缺点：调用出现问题，控制台没有提示信息
 * @author: fandp
 * @create: 2020-05-08 18:33
 **/
@Service
public class ProductServiceFallback  implements ProductService{
    @Override
    public Product product(Integer pid) {
        //容错逻辑
        Product product = new Product();
        product.setPid(-100);
        product.setPname("商品微服务调用出现异常了,已经进入到了容错方法中");
        return product;
    }
}
