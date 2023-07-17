package com.xiafish.service;



public interface ShoppingCartService {
    void addToCart(Integer userId, Integer goodsId, Integer collectNum);

    void getCart(Integer userId, Integer page, Integer pageSize);
}
