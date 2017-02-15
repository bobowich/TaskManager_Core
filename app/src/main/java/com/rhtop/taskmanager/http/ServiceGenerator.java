package com.rhtop.taskmanager.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bobowich
 * Time: 2017/2/15.
 */

public class ServiceGenerator {
    private static final String BASE_URL = "";
    private static OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static <T> T createService(Class<T> apiService){
        Retrofit retrofit = builder.build();
        return  retrofit.create(apiService);
    }
}
