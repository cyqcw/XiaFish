package com.xiafish.service;

import com.xiafish.pojo.Goods;
import com.xiafish.pojo.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer userId);

    void updateUser(User user);

    Integer getIdByUserNameAndPassword(String username,String password);

    void addUser(String username, String password);

    List<Goods> getGoodsByUserId(Integer userId);

    void releaseGoods(Goods goods);

}
