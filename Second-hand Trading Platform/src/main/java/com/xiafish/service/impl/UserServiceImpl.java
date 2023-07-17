package com.xiafish.service.impl;

import com.xiafish.mapper.UserMapper;
import com.xiafish.pojo.User;
import com.xiafish.service.UserService;
import com.xiafish.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        String email = user.getUserEmail();
        String phoneNumber = user.getUserPhoneNum();

        // 验证邮箱和电话号码的格式
        if (email!=null && !ValidationUtils.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (phoneNumber!=null && !ValidationUtils.isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format");
        }

        userMapper.updateUser(user);

    }
}
