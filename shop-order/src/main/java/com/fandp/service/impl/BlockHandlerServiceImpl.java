package com.fandp.service.impl;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:  BlockException处理类
 * @author: fandp
 * @create: 2020-05-08 18:01
 **/
@Slf4j
public class BlockHandlerServiceImpl {
    //blockHandler 要求： 1. 当前方法的返回值和参数要跟原方法保持一致
    // 2. 允许在参数列表的最后加入一个参数BlockException，作用是用来接收原方法中发生的异常
    public static String  blockHandler(String name,BlockException e){
        //自定义异常处理逻辑
        log.error("触发了BlockException，内容为{ }",e);
        return "BlockException";
    }


}
