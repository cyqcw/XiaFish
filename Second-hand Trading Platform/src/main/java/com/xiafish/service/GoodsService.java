package com.xiafish.service;

import com.xiafish.pojo.Goods;
import com.xiafish.pojo.GoodsComment;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoods(String goodsName, Integer goodsCategoryId);

    Goods getGoodsById(Integer id);

    void purchaseById(Integer userId, Integer goodsId, Integer orderNum);

    void releaseComment(GoodsComment goodsComment);


    void uploadImgs(Integer goodsId, List<String> urls);

}
