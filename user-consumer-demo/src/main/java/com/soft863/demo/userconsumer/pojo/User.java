package com.soft863.demo.userconsumer.pojo;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 河南863<p>
 *
 * @author 闫聪
 * @since 2019/7/10 14:51
 */
public class User {
    int uid;
    String uname;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                '}';
    }
}
