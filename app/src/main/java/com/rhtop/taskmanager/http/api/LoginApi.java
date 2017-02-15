package com.rhtop.taskmanager.http.api;

import com.rhtop.taskmanager.http.bean.LoginResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by bobowich
 * Time: 2017/2/15.
 */

//登录请求
public interface LoginApi {

    @Headers({"Content-type:application/json", "Accept:application/json"})
    @POST("路径")
    Call<LoginResponse> login(@Body RequestBody body);
}
