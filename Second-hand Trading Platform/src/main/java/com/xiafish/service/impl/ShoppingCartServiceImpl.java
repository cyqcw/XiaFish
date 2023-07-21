package com.xiafish.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiafish.mapper.GoodsMapper;
import com.xiafish.mapper.OrderMapper;
import com.xiafish.mapper.ShoppingCartMapper;
import com.xiafish.pojo.*;
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
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void addToCart(Integer userId, Integer goodsId, Integer collectNum) {
        shoppingCartMapper.insertToCart(userId, goodsId, collectNum, LocalDateTime.now());
    }

    @Override
    public PageBean getCart(Integer userId, Integer page, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行条件分页查询
        List<ShoppingCart> shoppingCartsList=shoppingCartMapper.getShoppingCartsList(userId);
        //获取查询结果
        Page<ShoppingCart> p = (Page<ShoppingCart>) shoppingCartsList;
        // 封装PageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        // 返回查询结果
        return pageBean;
    }

    @Override
    public void updateShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartMapper.updateShoppingCart(shoppingCart);
    }

    @Override
    public void buyFromShoppingCart(ShoppingCart shoppingCart) {
        Order order=new Order();
        shoppingCart=shoppingCartMapper.getShoppingCartById(shoppingCart.getShoppingCartId());
        order.setBuyerId(shoppingCart.getUserId());
        order.setOrderNum(shoppingCart.getCollectNum());
        order.setGoodsId(shoppingCart.getGoodsId());
        Goods goods =goodsMapper.getById(shoppingCart.getGoodsId());
        order.setSellerId(goods.getSellerId());
        order.setOrderSumPrice(goods.getCurPrice()*shoppingCart.getCollectNum());
        order.setOrderDateTime(LocalDateTime.now());
        //设置状态为已拍下
        order.setOrderStatus("1");
        orderMapper.addOrder(order);

    }

    @Override
    public void deleteShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartMapper.deleteShoppingCart(shoppingCart);
    }
}
