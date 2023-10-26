package com.javaclimb.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.javaclimb.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/*
控制器全局异常拦截
* */
@ControllerAdvice(basePackages = "com.javaclimb.controller")
public class GlobalExceptionHandler {

    private static final Log log = LogFactory.get();

    @ExceptionHandler(Exception.class)  //统一异常处理，主要用于Exception
    @ResponseBody //返回json串
    public Result error(HttpServletRequest request, Exception e){
        log.error("异常信息",e);
        return Result.error();
    }
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result customError(HttpServletRequest request,CustomException e){
        log.error("异常信息",e.getMsg());
        return Result.error(e.getCode(),e.getMsg());
    }
}
