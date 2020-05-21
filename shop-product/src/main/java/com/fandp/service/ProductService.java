package com.fandp.service;

import com.fandp.domain.Product;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-07 09:17
 **/
public interface ProductService {
    Product findByPid(Integer pid);
}
