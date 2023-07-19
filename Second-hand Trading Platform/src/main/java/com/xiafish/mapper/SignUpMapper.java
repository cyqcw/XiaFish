package com.xiafish.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignUpMapper {

    @Insert("insert into xiafish.user(user_name,user_passwd) values(#{username},#{password})")
    void addUser(String username, String password);

}
