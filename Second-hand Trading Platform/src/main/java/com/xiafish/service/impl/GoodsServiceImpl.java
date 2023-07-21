package com.xiafish.service.impl;

import com.xiafish.mapper.GoodsMapper;
import com.xiafish.pojo.Goods;
import com.xiafish.pojo.GoodsComment;
import com.xiafish.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> getGoods(String goodsName, Integer goodsCategoryId) {
        return goodsMapper.searchGoods(goodsName, goodsCategoryId);
    }

    @Override
    public Goods getGoodsById(Integer id) {
        return goodsMapper.getById(id);
    }

    @Override
    public void purchaseById(Integer userId, Integer goodsId, Integer orderNum) {
        Integer sellerId=goodsMapper.getSellerId(goodsId);
        Float goodsPrice=goodsMapper.getGoodsPrice(goodsId);
        String orderStatus="已下单";

        goodsMapper.purchaseById(userId,sellerId,goodsId,orderNum,
                orderNum*goodsPrice,orderStatus,LocalDateTime.now());
    }

    @Override
    public void releaseComment(GoodsComment goodsComment) {
        goodsMapper.addComment(goodsComment);
    }

    public void uploadImgs(Integer goodsId, List<String> urls) {
        goodsMapper.insertImages(goodsId,urls);

    }
}
