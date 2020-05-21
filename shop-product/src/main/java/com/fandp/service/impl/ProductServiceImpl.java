package com.fandp.service.impl;

import com.fandp.dao.ProductDao;
import com.fandp.domain.Product;
import com.fandp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-07 09:17
 **/
@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }
}
