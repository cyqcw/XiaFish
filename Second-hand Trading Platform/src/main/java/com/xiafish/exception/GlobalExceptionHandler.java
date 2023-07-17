package com.xiafish.exception;

import com.xiafish.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CartDuplicateExceptionHandler {
    //该异常用于处理用户向购物车中添加了同一个商品
    @ExceptionHandler(Exception.class)
    public Result CartException(CartDuplicateExceptionHandler ex){
        return Result.error("该商品已经加入购物车");
    }
}
