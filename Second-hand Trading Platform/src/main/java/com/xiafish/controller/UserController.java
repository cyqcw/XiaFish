package com.xiafish.controller;

import com.xiafish.pojo.*;
import com.xiafish.service.UserService;
import com.xiafish.util.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public Result getUserInfo(@RequestParam("userId") Integer userId){
        log.info("查询的用户id：{}", userId);
        User user = userService.getUserById(userId);
        return Result.success(user);
    }

    @PatchMapping("/user/update")
    public Result updateUser(@RequestBody User user){
        try {
        log.info("更新的用户id：{}", user);
        userService.updateUser(user);
        return Result.success();
        }catch (Exception e)
        {
         return Result.error(e.getMessage());
        }
    }
    @GetMapping("user/goods")
    public Result getGoodsByUserId(@RequestParam("userId")  Integer userId)
    {
            List<Goods> goodsList = userService.getGoodsByUserId(userId);
            return Result.success(goodsList);
    }
    @PutMapping("user/release")
    public Result releaseGoods(@RequestBody Goods goods)
    {
            //设置商品发布时间
            goods.setReleaseTime(LocalDateTime.now());
            log.info("发布商品：{}", goods);
            userService.releaseGoods(goods);
            return Result.success();
    }
    @DeleteMapping("user/goods/{goodsIds}")
    public Result deleteGoods(@RequestParam("userId") Integer userId,
                              @PathVariable List<Integer> goodsIds)
    {
        log.info("用户 {} 删除商品：{}",userId, goodsIds.toString());
        userService.deleteGoods(userId,goodsIds);
        return Result.success();
    }
    @GetMapping("user/order/{userid}")
    public Result findOrder(@PathVariable Integer userid)
    {
        List<Order> userOrdersList= userService.findOrder(userid);
        return Result.success(userOrdersList);
    }
    @GetMapping("user/comment/{userid}")
    public Result findComment(@PathVariable Integer userId)
    {
        List<UserComment> userCommentsList= userService.findComment(userId);
        return Result.success(userCommentsList);
    }
    @GetMapping("user/shoppingcart")
    public Result viewShoppingCart(@RequestParam("userId") Integer userid)
    {
        List<ShoppingCart> shoppingCarts=userService.viewShoppingCart(userid);
        return Result.success(shoppingCarts);
    }
    @PatchMapping("user/goods/update")
    public Result updateUserGoods(@RequestBody Goods goods)
    {
        userService.updateUserGoods(goods);
        return Result.success();
    }
}
