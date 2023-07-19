package com.xiafish.service.impl;

import com.xiafish.mapper.UserMapper;
import com.xiafish.pojo.*;
import com.xiafish.service.UserService;
import com.xiafish.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public void updateUser(User user) throws RuntimeException{
//        String email = user.getUserEmail();
//        String phoneNumber = user.getUserPhoneNum();
//
//        // 验证邮箱和电话号码的格式
//        if (email!=null && !ValidationUtils.isValidEmail(email)) {
//            throw new IllegalArgumentException("Invalid email format");
//        }
//
//        if (phoneNumber!=null && !ValidationUtils.isValidPhoneNumber(phoneNumber)) {
//            throw new IllegalArgumentException("Invalid phone number format");
//        }
            userMapper.updateUser(user);
    }

    @Override
    public Integer getIdByUserNameAndPassword(String username,String password)throws RuntimeException{
        Integer userId=userMapper.getIdByNameAndPassword(username,password);
        if(userId == null)throw new RuntimeException("用户名或密码错误");
        return userId;
    }

    @Override
    public void addUser(String username, String password) throws RuntimeException{
        try {
            userMapper.addUser(username, password);
        }catch (RuntimeException e)
        {
            e.printStackTrace();
         throw new RuntimeException("用户名已存在");
        }

    }

    @Override
    public List<Goods> getGoodsByUserId(Integer userId) {
        return userMapper.goodsList(userId);
    }

    @Override
    public void releaseGoods(Goods goods) {
        userMapper.addGoods(goods);
    }

    @Override
    public void deleteGoods(Integer userId,List<Integer> goodsids) {
        userMapper.deleteGoods(userId,goodsids);
    }

    @Override
    public List<UserComment> findComment(Integer userid) {
        List<UserComment>userCommentList=userMapper.selectcomment(userid);
        return userCommentList;
    }

    @Override
    public List<ShoppingCart> viewShoppingCart(Integer userid) {
        List<ShoppingCart> shoppingCartsList=userMapper.selectShoppingCart(userid);
        return shoppingCartsList;
    }

    @Override
    public List<Order> findOrder(Integer userid) {
        List<Order>userOrdersList=userMapper.selectOrder(userid);
        return userOrdersList;
    }

    @Override
    public void updateHeadImg(Integer userId, String url) {
        userMapper.updateHeadImg(userId,url);
    }

}
