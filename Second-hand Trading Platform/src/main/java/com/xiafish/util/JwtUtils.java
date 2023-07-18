package com.xiafish.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String signKey="XiaXiaoYu";//密钥

    public static String generateJwt(Map<String,Object> claims){
        //设置token有效时间为1个小时
        long expire = 4320000L;
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,signKey)//签名算法
                .setClaims(claims)//自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis()+ expire))//设置有效期为1h
                .compact();
    }

    public static Claims parseJwt(String jwt){
        return Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt).getBody();
    }
}
