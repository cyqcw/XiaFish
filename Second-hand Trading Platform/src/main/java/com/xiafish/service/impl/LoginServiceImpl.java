package com.xiafish.service.impl;

import com.xiafish.mapper.LoginMapper;
import com.xiafish.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public Integer getIdByUserNameAndPassword(String username,String password)throws RuntimeException{
        Integer userId=loginMapper.getIdByNameAndPassword(username,password);
        if(userId == null)throw new RuntimeException("用户名或密码错误");
        return userId;
    }
}
