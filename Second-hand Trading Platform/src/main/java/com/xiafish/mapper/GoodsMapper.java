package com.xiafish.mapper;

import com.xiafish.pojo.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface GoodsMapper {

    List<Goods> searchGoods(String name,Integer goodsCategoryId);

    @Select("select * from xiafish.goods where goods_id=#{id}")
    Goods getById(Integer id);

    @Select("select user_id from xiafish.user,xiafish.goods " +
            "where goods.seller_id=user.user_id and goods_id=#{goodsId}")
    Integer getSellerId(Integer goodsId);

    @Select("select cur_price from xiafish.goods where goods_id=#{goodsId}")
    Float getGoodsPrice(Integer goodsId);

    @Insert("insert into xiafish.`order`(buyer_id, seller_id, goods_id, order_num, " +
            "order_sum_price, order_status, order_date_time)" +
            " values(#{buyerId},#{sellerId},#{goodsId},#{orderNum},#{orderSumPrice},#{orderStatus},#{now})")
    void purchaseById(Integer buyerId, Integer sellerId, Integer goodsId, Integer orderNum,
                      float orderSumPrice, String orderStatus, LocalDateTime now);
}
