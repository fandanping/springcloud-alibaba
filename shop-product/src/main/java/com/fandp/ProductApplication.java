package com.fandp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-02 17:19
 **/
@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args){
        SpringApplication.run(ProductApplication.class,args);
    }
}
