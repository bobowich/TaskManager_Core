package com.rhtop.taskmanager.ui.activity;

import android.os.Bundle;

import com.rhtop.taskmanager.R;
import com.rhtop.taskmanager.ui.widget.TitleBarLayout;

//在HomepageFragment，点击单人信息条目，进入TaskListActivity(任务列表界面)，可以查看该人所完成任务的详情
public class TaskListActivity extends BaseActivity {

    private TitleBarLayout titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        initView();
    }

    private void initView() {
        titleBar = (TitleBarLayout) findViewById(R.id.title_bar);
        titleBar.setTitleBarListener(this);
    }
}
