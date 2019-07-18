package com.soft863.demo.userservice.service;

import com.soft863.demo.userservice.mapper.UserMapper;
import com.soft863.demo.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        // 为了演示超时现象，我们在这里然线程休眠,时间随机 0~2000毫秒
       /* try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return this.userMapper.selectByPrimaryKey(id);
    }
}