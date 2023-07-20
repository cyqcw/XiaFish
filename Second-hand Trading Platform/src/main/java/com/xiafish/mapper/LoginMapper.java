package com.xiafish.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("select user_id from xiafish.user where user_name=#{username} and user_passwd=#{password}")
    Integer getIdByNameAndPassword(String username,String password);

    @Select("select user_status from xiafish.user where user_id=#{usrId}")
    Integer getStatusByUserId(Integer userId);
}
