package com.rhtop.taskmanager.ui.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rhtop.taskmanager.R;
//在SelfFragment中点击问题反馈进入问题FeedbackActivity，可以反馈自己遇到的问题
public class FeedbackActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
    }
}
