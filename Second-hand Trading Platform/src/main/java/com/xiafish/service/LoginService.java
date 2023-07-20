package com.xiafish.service;

public interface LoginService {
    Integer getIdByUserNameAndPassword(String username,String password);

    Integer getStatusByUserId(Integer userId);
}
