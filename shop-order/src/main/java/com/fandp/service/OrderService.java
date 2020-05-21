package com.fandp.service;

import com.fandp.domain.Order;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-07 09:17
 **/
public interface OrderService {
    Order createOrder(Order order);
    String message(String name);
}
