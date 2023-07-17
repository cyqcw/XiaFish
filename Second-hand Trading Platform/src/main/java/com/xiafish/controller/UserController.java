package com.xiafish.controller;

import com.xiafish.pojo.Goods;
import com.xiafish.pojo.Result;
import com.xiafish.pojo.User;
import com.xiafish.service.UserService;
import com.xiafish.util.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public Result getUserInfo(HttpServletRequest request){
        String jwt=request.getHeader("token");
        Integer userId = JwtUtils.parseJwt(jwt).get("id", Integer.class);
        log.info("jwt中获取的用户id：{}", userId);
        // 调用UserService查询指定用户的个人信息
        User user = userService.getUserById(userId);
        return Result.success(user);
    }

    @PatchMapping("/user/update")
    public Result updateUser(@RequestBody User user){
        log.info("更新的用户id：{}", user.getUserId());
        userService.updateUser(user);
        return Result.success();
    }

}
