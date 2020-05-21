package com.fandp.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-02 16:38
 **/
@Entity(name="shop_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer uid;
    private String username;
    private String password;
    private String telphone;
}
