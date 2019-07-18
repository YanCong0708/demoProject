package com.soft863.controller;

import com.soft863.pojo.User;
import com.soft863.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 河南863<p>
 *
 * @author 闫聪
 * @since 2019/7/6 11:22
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public List<User> hello() {
        List<User> user = this.userService.queryById(8L);
        return user;
    }

    @GetMapping("/all")
    public String all(ModelMap model) {
        List<User> users = this.userService.queryById(8L);
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/test")
    public String test() {
        return "users";
    }

}
