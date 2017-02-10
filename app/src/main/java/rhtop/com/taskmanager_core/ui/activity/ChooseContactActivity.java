package rhtop.com.taskmanager_core.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import rhtop.com.taskmanager_core.R;

//在任务详情界面点击指派人或者关注人后进入ChooseContactActivity(选择联系人界面)
public class ChooseContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_contact);
    }
}
