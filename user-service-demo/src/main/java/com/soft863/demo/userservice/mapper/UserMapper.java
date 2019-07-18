package com.soft863.demo.userservice.mapper;

import com.soft863.demo.userservice.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
    @Override
    @Select("select * from user where uid=#{key}")
    User selectByPrimaryKey(Object key);
}