package rhtop.com.taskmanager_core.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rhtop.com.taskmanager_core.R;
//在PandectFragment，点击单人信息条目，进入TaskListActivity(任务列表界面)，可以查看该人所完成任务的详情
public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
    }
}
