package com.rhtop.taskmanager.ui.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rhtop.taskmanager.R;

//在SelfFragment点击使用帮助，进入HelperActivity(使用帮助)
public class HelperActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);
    }
}
