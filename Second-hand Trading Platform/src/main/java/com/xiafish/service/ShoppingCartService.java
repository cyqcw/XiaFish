package com.xiafish.service;


import com.xiafish.pojo.ShoppingCart;

public interface ShoppingCartService {
    void addToCart(Integer userId, Integer goodsId, Integer collectNum);

    ShoppingCart getCart(Integer userId, Integer page, Integer pageSize);
}
