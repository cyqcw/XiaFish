package com.xiafish.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiafish.pojo.Result;
import com.xiafish.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class LoginController implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取请求中的url
        String url= request.getRequestURI().toString();
        log.info("url:{}",url);

        //是登录操作和主页面浏览操作直接进行放行，否则拦截器进行拦截
        if(url.contains("login")||url.contains("goods/all")){
            return true;
        }

        //获取请求中的令牌
        String jwt=request.getHeader("token");

        //判断令牌是否存在
        if(!StringUtils.hasLength(jwt)){
            log.info("token为空，返回未登录");
            Result error=Result.error("NOT_LOGIN");
            String notLogin= JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        //解析token
        try {
            JwtUtils.parseJwt(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("令牌解析失败");
            Result error=Result.error("NOT_LOGIN");
            String notLogin=JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        //登录成功则进行放行操作，允许访问后续的web操作
        return true;
    }

}
