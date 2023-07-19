package com.xiafish.controller;

import com.xiafish.pojo.Goods;
import com.xiafish.pojo.Result;
import com.xiafish.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @GetMapping("/goods/all")
    public Result getGoods(String goodsName,Integer goodsCategoryId) {
        List<Goods> goodsList=goodsService.getGoods(goodsName,goodsCategoryId);
        return Result.success(goodsList);
    }

    //功能待扩展
    @GetMapping("/goods")
    public Result getGoodsById(@RequestParam("goodsId") Integer Id){
        log.info("根据商品id查找商品{}",Id);
        Goods goods=goodsService.getGoodsById(Id);
        return Result.success(goods);
    }

    @PostMapping("/goods/purchase")
    public Result purchaseById(@RequestParam("buyerId") Integer userId,
                               @RequestParam("goodsId") Integer goodsId,
                               @RequestParam(value = "orderNum", defaultValue = "1") Integer orderNum){
        log.info("用户 {} 直接购买商品 {}，数量为 {}",userId,goodsId,orderNum);
        goodsService.purchaseById(userId,goodsId,orderNum);
        return  Result.success();
    }

}
