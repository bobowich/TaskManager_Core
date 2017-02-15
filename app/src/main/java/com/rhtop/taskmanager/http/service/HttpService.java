package com.rhtop.taskmanager.http.service;

import com.rhtop.taskmanager.http.bean.LoginRequest;
import com.rhtop.taskmanager.http.bean.LoginResponse;
import com.rhtop.taskmanager.http.callback.HttpCallBack;

/**
 * Created by bobowich
 * Time: 2017/2/15.
 */

public interface HttpService {
    void login(LoginRequest loginRequest, HttpCallBack<LoginResponse> httpCallBack);
}
