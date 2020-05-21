package com.fandp.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fandp.domain.Order;
import com.fandp.domain.Product;
import com.fandp.service.OrderService;
import com.fandp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-07 09:15
 **/
@RestController
@Slf4j
public class OrderController {
    //    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @RequestMapping("/order/prod/{pid}")
    public Order createOrder(@PathVariable("pid") Integer pid){
        Order order =new Order();
       // Product product =restTemplate.getForObject("http://localhost:8082/product/"+pid,Product.class);
        Product product = productService.product(pid);
        if(product.getPid() == -100){
            Order ordertest =new Order();
            ordertest.setOid(-1);
            ordertest.setPname("下单失败");
              return ordertest;
        }
        order.setNumber(1);
        order.setOid(2);
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setUid(1);
        order.setUsername("正式");
        return orderService.createOrder(order);
    }

    @RequestMapping("/order/message")
    public String message(){
        return orderService.message("test");
    }
}
