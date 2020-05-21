package com.fandp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-09 11:15
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args){
        SpringApplication.run(GatewayApplication.class,args);
    }
}
