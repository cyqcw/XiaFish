package com.xiafish.controller;

import com.xiafish.pojo.Result;
import com.xiafish.pojo.ShoppingCart;
import com.xiafish.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PutMapping("goods/cart")
    public Result addToCart(@RequestParam("userId") Integer userId,
                            @RequestParam("goodsId") Integer goodsId,
                            @RequestParam(value = "collectNum", defaultValue = "1") Integer collectNum){
        log.info("用户 {} 将商品 {}加入购物车，数量为 {}", userId, goodsId, collectNum);
        try {
            shoppingCartService.addToCart(userId,goodsId,collectNum);
            return Result.success();
        }catch (Exception e){
            return Result.error("该商品已加入购物车");
        }
    }

    @GetMapping("/shoppingcart")
    public Result getCart(@RequestParam("userId") Integer userId,
                          @RequestParam(value = "page",defaultValue = "1") Integer page,
                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        log.info("分页查询用户{}的购物车信息，当前为第{}页，每页有{}条数据",userId,page,pageSize);

        List<ShoppingCart> list=shoppingCartService.getCart(userId,page,pageSize);
        return Result.success(list);
    }
}
