package com.xiafish.service.impl;

import com.xiafish.mapper.ShoppingCartMapper;
import com.xiafish.pojo.ShoppingCart;
import com.xiafish.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
    public List<ShoppingCart> getCartList(Integer userId, Integer page, Integer pageSize) {
        return shoppingCartMapper.getCartListByUserId(userId,page,pageSize);
    }
}
