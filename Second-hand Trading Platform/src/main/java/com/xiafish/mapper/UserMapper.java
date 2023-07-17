package com.xiafish.mapper;

import com.xiafish.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from xiafish.user where user_id=#{userId}")
    User getUserById(Integer userId);

    void updateUser(User user);
}
