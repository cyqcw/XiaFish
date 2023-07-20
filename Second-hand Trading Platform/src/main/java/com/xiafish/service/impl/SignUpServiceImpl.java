package com.xiafish.service.impl;

import com.xiafish.mapper.SignUpMapper;
import com.xiafish.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private SignUpMapper signUpMapper;
    @Override
    public void addUser(String username, String password) throws RuntimeException{
        try {
            signUpMapper.addUser(username, password);
        }catch (RuntimeException e)
        {
            e.printStackTrace();
            throw new RuntimeException("用户名已存在");
        }

    }
}
