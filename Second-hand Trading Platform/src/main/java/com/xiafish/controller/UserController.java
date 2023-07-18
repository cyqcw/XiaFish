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
    @PostMapping("/login")
    public Result login(@RequestBody Map<String, Object> loginBody)
    {
        String username=(String) loginBody.get("username");
        String password=(String) loginBody.get("password");
        Map<String, Object> claims = new HashMap<>();
        Integer userId;
        try {
            userId = userService.getIdByUserNameAndPassword(username, password);
            claims.put("id", userId);
            String jwt = JwtUtils.generateJwt(claims);
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("userId", userId);
            responseData.put("token", jwt);
            return Result.success(responseData);
        }catch (RuntimeException e)
        {
            log.info(e.getMessage());
            return Result.error("Incorrect username or password");
        }
    }
    @PostMapping("/signup")
    public Result signUp(@RequestBody Map<String, Object> loginBody)
    {
         String username=(String) loginBody.get("username");
         String password=(String) loginBody.get("password");
         try
         {
             userService.addUser(username,password);
             return Result.success();
         }
         catch (RuntimeException e)
         {
             log.info(e.getMessage());
             return Result.error("the username has existed");
         }
    }

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
    public Result getGoodsByUserId( @PathVariable(value = "userid") Integer userId)
    {
            List<Goods> goodsList = userService.getGoodsByUserId(userId);
            return Result.success(goodsList);
    }
    @PutMapping("user/release")
    public Result releaseGoods(@RequestBody Goods good)
    {
            //设置商品发布时间
            good.setReleaseTime(LocalDateTime.now());
            log.info("发布商品：{}", good.toString());
            userService.releaseGoods(good);
            return Result.success();
    }
    @DeleteMapping("user/goods/{goodsids}")
    public Result deleteGoods(HttpServletRequest request,@PathVariable List<Integer> goodsids)
    {
        String jwt=request.getHeader("token");
        Integer userId = JwtUtils.parseJwt(jwt).get("id", Integer.class);
        log.info("用户 {} 删除商品：{}",userId, goodsids.toString());
        userService.deleteGoods(userId,goodsids);
        return Result.success();
    }
    @GetMapping("user/comment/{userid}")
    public Result findComment(@PathVariable Integer userid)
    {
        List<UserComment> userCommentsList= userService.findComment(userid);
        return Result.success(userCommentsList);
    }
    @GetMapping("user/shoppingcart/{userid}")
    public Result viewShoppingCart(@PathVariable Integer userid)
    {
        List<ShoppingCart> shoppingCarts=userService.viewShoppingCart(userid);
        return Result.success(shoppingCarts);
    }
}
