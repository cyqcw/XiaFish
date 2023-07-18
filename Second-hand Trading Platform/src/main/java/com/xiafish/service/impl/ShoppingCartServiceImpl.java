package com.xiafish.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiafish.mapper.ShoppingCartMapper;
import com.xiafish.pojo.PageBean;
import com.xiafish.pojo.ShoppingCart;
import com.xiafish.pojo.User;
import com.xiafish.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public void addToCart(Integer userId, Integer goodsId, Integer collectNum) {
        shoppingCartMapper.insertTocart(userId,goodsId,collectNum, LocalDateTime.now());
    }

    @Override
    public List<ShoppingCart> getCart(Integer userId, Integer page, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行条件分页查询
        List<ShoppingCart> shoppingCartsList=shoppingCartMapper.getShoppingCartsList(userId);
        //获取查询结果
        Page<ShoppingCart> p = (Page<ShoppingCart>) shoppingCartsList;
        //返回查询结果
        return p.getResult();
    }
}
