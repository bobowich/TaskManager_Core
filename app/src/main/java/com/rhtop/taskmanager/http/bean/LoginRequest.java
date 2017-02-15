package com.rhtop.taskmanager.http.bean;

/**
 * Created by bobowich
 * Time: 2017/2/15.
 */

//登录请求Json数据对应的实体类
public class LoginRequest {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
