package com.xiafish.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface ShoppingCartMapper {
    @Insert("insert into xiafish.shopping_cart (user_id, goods_id, collect_num, collect_time) " +
            "values (#{userId},#{goodsId},#{collectNum},#{now})")
    void insertTocart(Integer userId, Integer goodsId, Integer collectNum, LocalDateTime now);
}
