package com.soft863.demo.userconsumer.service;

import com.soft863.demo.userconsumer.dao.UserDao;
import com.soft863.demo.userconsumer.dao.UserFeignClient;
import com.soft863.demo.userconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserFeignClient userFeignClient;
    public List<User> querUserByIds(List<Long> ids){
        List<User> users = new ArrayList<>();
        for (Long id : ids) {
           User user = this.userFeignClient.queryUserById(id);
           // User user = this.userDao.queryUserById(id);
            users.add(user);
        }
        return users;
    }
}