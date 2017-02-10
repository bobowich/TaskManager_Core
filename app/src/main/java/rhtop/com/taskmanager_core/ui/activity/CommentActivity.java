package rhtop.com.taskmanager_core.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rhtop.com.taskmanager_core.R;

//任务页面中点击跟进讨论后进入任务CommentActivity(任务归档)
public class CommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
    }
}
