package com.xiafish.mapper;

import com.xiafish.pojo.Goods;
import com.xiafish.pojo.User;
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
}
