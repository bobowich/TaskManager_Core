package rhtop.com.taskmanager_core.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rhtop.com.taskmanager_core.R;

//创建新任务的Activity---NewTaskAvtivity，有两个途径：1 在主界面点击创建新任务；2 在任务详情中点击创建子任务
public class NewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
    }
}
