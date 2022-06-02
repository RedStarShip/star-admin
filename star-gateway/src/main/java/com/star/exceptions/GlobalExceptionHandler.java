package com.star.exceptions;

import com.star.gateway.filter.factory.TokenGatewayFilterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice//控制器增强
public class GlobalExceptionHandler  {
    private static final Logger log = LoggerFactory.getLogger(TokenGatewayFilterFactory.class);

    //自定义异常处理
    @ExceptionHandler//用来处理controller指定异常
    public Map<String,String> exception(Exception exception){
        log.info("exception",exception.getMessage());
        HashMap<String,String> result = new HashMap<>();
        result.put("msg",exception.getMessage());
        return result;
    }

}
