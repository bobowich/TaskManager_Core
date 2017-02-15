package com.rhtop.taskmanager.http.callback;

/**
 * Created by bobowich
 * Time: 2017/2/15.
 */

public interface HttpCallBack<T> {
    void onSuccess(T t);
    void onFailure(String failure);
}
