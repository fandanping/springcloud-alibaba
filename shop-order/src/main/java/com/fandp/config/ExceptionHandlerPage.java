package com.fandp.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 自定义返回异常页面
 * @author: fandp
 * @create: 2020-05-08 16:13
 **/
@Component
public class ExceptionHandlerPage implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ResponseData responseData =null;
        if(e instanceof FlowException){
            responseData = new ResponseData(-1,"限流异常");
        } else if(e instanceof DegradeException){
            responseData = new ResponseData(-2,"降级异常");
        } else if(e instanceof ParamFlowException){
            responseData = new ResponseData(-3,"参数限流异常");
        } else if(e instanceof ParamFlowException){
            responseData =  new ResponseData(-4,"授权异常");
        } else if(e instanceof SystemBlockException){
            responseData = new ResponseData(-5,"系统负载异常");
        }
        httpServletResponse.getWriter().write(JSON.toJSONString(responseData));
    }
}
@Data
@AllArgsConstructor  //全参构造
@NoArgsConstructor //无参构造
class ResponseData{
    private int code;
    private String message;

}
