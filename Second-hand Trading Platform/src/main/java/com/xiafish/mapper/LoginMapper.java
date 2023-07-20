package com.xiafish.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface LoginMapper {

    @Select("select user_id,user_passwd from xiafish.user where user_name=#{username}")
    Map<String, Object> getIdByName(String username);

}
