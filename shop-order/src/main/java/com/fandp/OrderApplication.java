package com.fandp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-02 17:19
 **/
@SpringBootApplication
@EnableFeignClients
public class OrderApplication {
    public static void main(String[] args){
        SpringApplication.run(OrderApplication.class,args);
    }
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
