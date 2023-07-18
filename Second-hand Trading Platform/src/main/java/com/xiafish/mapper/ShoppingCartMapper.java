package com.xiafish.mapper;

import com.xiafish.pojo.ShoppingCart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    @Insert("insert into xiafish.shopping_cart (user_id, goods_id, collect_num, collect_time) " +
            "values (#{userId},#{goodsId},#{collectNum},#{now})")
    void insertToCart(Integer userId, Integer goodsId, Integer collectNum, LocalDateTime now);

    List<ShoppingCart> getCartListByUserId(Integer userId, Integer page, Integer pageSize);
}
