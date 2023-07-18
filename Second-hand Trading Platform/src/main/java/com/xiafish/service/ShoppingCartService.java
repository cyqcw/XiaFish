package com.xiafish.service;


import com.xiafish.pojo.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    void addToCart(Integer userId, Integer goodsId, Integer collectNum);

    List<ShoppingCart> getCart(Integer userId, Integer page, Integer pageSize);
}
