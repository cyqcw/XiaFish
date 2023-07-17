package com.xiafish.service.impl;

import com.xiafish.exception.DuplicateItemException;
import com.xiafish.exception.GlobalExceptionHandler;
import com.xiafish.mapper.ShoppingCartMapper;
import com.xiafish.pojo.Result;
import com.xiafish.pojo.ShoppingCart;
import com.xiafish.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public void addToCart(Integer userId, Integer goodsId, Integer collectNum) {
        shoppingCartMapper.insertToCart(userId, goodsId, collectNum, LocalDateTime.now());
    }

    @Override
    public ShoppingCart getCart(Integer userId, Integer page, Integer pageSize) {
        return shoppingCartMapper.getCartByUserId(userId,page,pageSize);
    }
}
