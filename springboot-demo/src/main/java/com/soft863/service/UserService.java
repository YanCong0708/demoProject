package com.soft863.service;

import com.soft863.mapper.UserMapper;
import com.soft863.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryById(Long id) {
        return this.userMapper.selectUser();
    }

    @Transactional
    public void deleteById(Long id) {
        // this.userMapper.deleteByPrimaryKey(id);
    }
}