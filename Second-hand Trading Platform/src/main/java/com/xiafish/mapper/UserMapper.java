package com.xiafish.mapper;

import com.xiafish.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from xiafish.user where user_id=#{userId}")
    User getUserById(Integer userId);

    void updateUser(User user);

    @Select("select user_id from xiafish.user where user_name=#{username} and user_passwd=#{password}")
    Integer getIdByNameAndPassword(String username,String password);
    @Insert("insert into xiafish.user(user_name,user_passwd) values(#{username},#{password})")
    void addUser(String username, String password);
    @Select("select goods.* from xiafish.goods where seller_id=#{userId}")
    List<Goods> goodsList(Integer userId);

    void addGoods(Goods goods);
    void deleteGoods(Integer userId,List<Integer> goodsids);

    @Select("select * from user_comment where seller_id = #{userid}")
    List<UserComment> selectcomment(Integer userid);
    @Select("select * from shopping_cart where user_id=#{userid}")
    List<ShoppingCart> selectShoppingCart(Integer userid);
    @Select("select * from xiafish.`order` where buyer_id = #{userid}")
    List<Order> selectOrder(Integer userid);
}
