package com.fandp.controller;

import com.fandp.domain.Product;
import com.fandp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-07 09:15
 **/
@RestController
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid){
      Product product =  productService.findByPid(pid);
      return product;
    }

    @RequestMapping("/product/api1/demo1")
    public String demo1(){
        return "demo1";
    }
    @RequestMapping("/product/api2/demo1")
    public String demo12(){
        return "demo12";
    }
    //没办法进行限流
    @RequestMapping("/product/api2/demo2")
    public String demo2(){
        return "demo2";
    }


}
