package rhtop.com.taskmanager_core.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rhtop.com.taskmanager_core.R;
//在SelfFragment点击任务归档 ，可以进入TaskArchiveActivity,查看已经完成的任务
public class TaskArchiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_archive);
    }
}
