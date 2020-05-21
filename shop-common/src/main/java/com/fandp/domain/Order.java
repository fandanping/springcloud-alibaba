package com.fandp.domain;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * @description:
 * @author: fandp
 * @create: 2020-05-02 16:39
 **/
@Entity(name="shop_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer oid;   //订单id
    private Integer uid;  // //用户id
    private String username; //用户名称
    private Integer pid; //商品id
    private String pname; //商品名称
    private Double pprice;  //商品单价
    private Integer number; //购买数量
}
