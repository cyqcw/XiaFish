package com.xiafish.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xiafish.pojo.Result;
import com.xiafish.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    private boolean debug=false;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //1.get url
        String url= request.getRequestURI();
        String userIdPath = request.getParameter("userId");
        log.info("url:{}",url);

        //2.判断url是否包含login或者signup
        if(url.contains("login")){
            log.info("登录操作，放行...");
            return true;
        }

        if(url.contains("signup")){
            log.info("注册操作，放行...");
            return true;
        }

        //3.获取令牌
        String jwt=request.getHeader("token");
        System.out.println(jwt);
        //4.判断令牌是否存在
        if(!StringUtils.hasLength(jwt)){
            log.info("token为空，返回未登录");
            Result error=Result.error("NOT_LOGIN");
            String notLogin= JSONObject.toJSONString(error);
            //设置响应头（告知浏览器：响应的数据类型为json、响应的数据编码表为utf-8）
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(notLogin);
            return false;
        }

        Integer userIdToken;
        //5.解析token
        try {
            userIdToken = JwtUtils.parseJwt(jwt).get("id", Integer.class);
        }catch (Exception e){
            e.printStackTrace();
            log.info("令牌解析失败");
            Result error=Result.error("NOT_LOGIN");
            String notLogin=JSONObject.toJSONString(error);
            //设置响应头（告知浏览器：响应的数据类型为json、响应的数据编码表为utf-8）
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(notLogin);
            return false;
        }

        if (!userIdToken.equals(Integer.parseInt(userIdPath))) {
            log.info("userId 校验失败");
            Result error = Result.error("INVALID_USERID");
            String invalidUserId = JSONObject.toJSONString(error);
            response.getWriter().write(invalidUserId);
            return false;
        }

        //6.放行
        return true;
    }

}
