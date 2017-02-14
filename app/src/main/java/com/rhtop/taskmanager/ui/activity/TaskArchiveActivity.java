package com.rhtop.taskmanager.ui.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rhtop.taskmanager.R;
//在SelfFragment点击任务归档 ，可以进入TaskArchiveActivity,查看已经完成的任务
public class TaskArchiveActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_archive);
    }
}
