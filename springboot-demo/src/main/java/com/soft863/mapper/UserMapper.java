package com.soft863.mapper;

import com.soft863.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Select("select * from user")
    List<User> selectUser();
}