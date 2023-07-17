package com.xiafish.mapper;

import com.xiafish.pojo.ShoppingCart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

@Mapper
public interface ShoppingCartMapper {
    @Insert("insert into xiafish.shopping_cart (user_id, goods_id, collect_num, collect_time) " +
            "values (#{userId},#{goodsId},#{collectNum},#{now})")
    void insertToCart(Integer userId, Integer goodsId, Integer collectNum, LocalDateTime now);

    @Select("select shopping_cart_id,shopping_cart.goods_id,goods_name,collect_num,cur_price,inventory,goods_img_url" +
            " from xiafish.shopping_cart,xiafish.goods,xiafish.goods_img " +
            "where goods.goods_id=goods_img.goods_id and shopping_cart.goods_id=goods.goods_id and user_id=#{userId};")
    ShoppingCart getCartByUserId(Integer userId, Integer page, Integer pageSize);
}
