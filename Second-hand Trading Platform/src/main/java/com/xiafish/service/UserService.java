package com.xiafish.service;

import com.xiafish.pojo.*;

import java.util.List;

public interface UserService {
    User getUserById(Integer userId);

    void updateUser(User user);

    Integer getIdByUserNameAndPassword(String username,String password);

    void addUser(String username, String password);

    List<Goods> getGoodsByUserId(Integer userId);

    void releaseGoods(Goods goods);

    void deleteGoods(Integer userId,List<Integer> goodsids);

    List<UserComment> findComment(Integer userid);

    List<ShoppingCart> viewShoppingCart(Integer userid);

    List<Order> findOrder(Integer userid);
    void updateHeadImg(Integer userId, String url);
}
