package com.xiafish.service;
import java.util.Map;

public interface LoginService {

    Map<String, Object> getIdByUserName(String username);

    Integer getIdByUserNameAndPassword(String username,String password);

    Integer getStatusByUserId(Integer userId);

}
