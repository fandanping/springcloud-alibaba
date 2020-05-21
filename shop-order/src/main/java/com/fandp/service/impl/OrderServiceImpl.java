package com.fandp.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.fandp.dao.OrderDao;
import com.fandp.domain.Order;
import com.fandp.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-07 09:17
 **/
@Service
@Slf4j
public class OrderServiceImpl  implements OrderService {
    int i=0;
    @Autowired
    private OrderDao orderDao;
    @Override
    public Order createOrder(Order order) {
        Order result =  orderDao.save(order);
        return result;
    }

    //blockHandler 定义当资源内部发生blockException应该进入的方法，捕获的是sentinel定义的异常。
    //定义当资源内部发生了throwable应该进入的方法
    @SentinelResource(value="message",blockHandlerClass = BlockHandlerServiceImpl.class,fallbackClass =FallbackServiceImpl.class, blockHandler = "blockHandler",fallback = "fallback")
    public String message(String name){
        if(i%3 ==0){
            throw new RuntimeException();
        }
        return "message";
    }
    //blockHandler 要求： 1. 当前方法的返回值和参数要跟原方法保持一致
    // 2. 允许在参数列表的最后加入一个参数BlockException，作用是用来接收原方法中发生的异常
   /* public String  blockHandler(String name,BlockException e){
        //自定义异常处理逻辑
        log.error("触发了BlockException，内容为{ }",e);
        return "BlockException";
    }*/

    //fallback 要求： 1. 当前方法的返回值和参数要跟原方法保持一致
    // 2. 允许在参数列表的最后加入一个参数Throwable，作用是用来接收原方法中发生的异常
   /* public String  fallback(String name,Throwable e){
        //自定义异常处理逻辑
        log.error("触发了Throwable，内容为{ }",e);
        return "Throwable";
    }*/
}
