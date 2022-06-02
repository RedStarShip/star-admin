package com.star.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//前后端分离处理异常方法  返回json数据
@ControllerAdvice//控制器增强
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //自定义异常处理
    @ExceptionHandler//用来处理controller指定异常
    @ResponseBody
    public Map<String,String> exception(Exception exception){
        log.info("exception",exception.getMessage());
        HashMap<String,String> result = new HashMap<>();
        result.put("msg",exception.getMessage());
        return result;
    }

}
