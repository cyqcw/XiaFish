package com.xiafish.controller;

import com.xiafish.pojo.Goods;
import com.xiafish.pojo.Result;
import com.xiafish.pojo.User;
import com.xiafish.service.UserService;
import com.xiafish.util.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/user/{userId}")
    public Result getUserInfo(@PathVariable Integer userId){
        User user = userService.getUserById(userId);
        return Result.success(user);
    }

    @PatchMapping("/user/update")
    public Result updateUser(@RequestBody User user){
        try {

        log.info("更新的用户id：{}", user.getUserId());
        userService.updateUser(user);
        return Result.success();
        }catch (Exception e)
        {
         return Result.error(e.getMessage());
        }
    }
    @GetMapping("user/goods/{userid}")
    public Result getGoodsByUserId( @PathVariable(value = "userid") Integer userId)
    {
            List<Goods> goodsList = userService.getGoodsByUserId(userId);
            return Result.success(goodsList);

    }
    @PutMapping("user/goods/release")
    public Result releaseGoods(HttpServletRequest request,@RequestBody Goods good)
    {
        String jwt=request.getHeader("token");
        Integer userId = JwtUtils.parseJwt(jwt).get("id", Integer.class);
        log.info("jwt中获取的用户id：{}", userId);
        if(Objects.equals(userId, good.getSellerId())) {
            log.info("发布商品：{}", good.toString());
            userService.releaseGoods(good);
            return Result.success();
        }
        else return Result.error("sellerId error");
    }

}
