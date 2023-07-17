package com.xiafish.service.impl;

import com.xiafish.mapper.ShoppingCartMapper;
import com.xiafish.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public void addToCart(Integer userId, Integer goodsId, Integer collectNum) {
        shoppingCartMapper.insertTocart(userId,goodsId,collectNum, LocalDateTime.now());
    }

    @Override
    public void getCart(Integer userId, Integer page, Integer pageSize) {
        //todo
    }
}
