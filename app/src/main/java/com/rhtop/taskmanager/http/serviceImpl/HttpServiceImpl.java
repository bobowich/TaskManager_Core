package com.rhtop.taskmanager.http.serviceImpl;

import com.google.gson.Gson;
import com.rhtop.taskmanager.http.ServiceGenerator;
import com.rhtop.taskmanager.http.api.LoginApi;
import com.rhtop.taskmanager.http.bean.LoginRequest;
import com.rhtop.taskmanager.http.bean.LoginResponse;
import com.rhtop.taskmanager.http.callback.HttpCallBack;
import com.rhtop.taskmanager.http.service.HttpService;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bobowich
 * Time: 2017/2/15.
 */

public class HttpServiceImpl implements HttpService {

    public static HttpServiceImpl instance;

    private HttpServiceImpl(){
        throw new IllegalStateException("cannot initial this object by this way.");
    }

    public static HttpServiceImpl getInstance(){
        if(instance == null){
            synchronized(HttpServiceImpl.class){
                if(instance == null){
                    instance = new HttpServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void login(LoginRequest loginRequest, final HttpCallBack<LoginResponse> callBack) {
        LoginApi loginApi = ServiceGenerator.createService(LoginApi.class);
        String loginString = new Gson().toJson(loginRequest);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), loginString);
        Call<LoginResponse> call = loginApi.login(requestBody);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                callBack.onSuccess(loginResponse);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callBack.onFailure("网络请求失败");
            }
        });
    }
}
