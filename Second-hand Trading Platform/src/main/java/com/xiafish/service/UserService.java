package com.xiafish.service;

import com.xiafish.pojo.User;

public interface UserService {
    User getUserById(Integer userId);

    void updateUser(User user);
}
