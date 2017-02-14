package com.rhtop.taskmanager.ui.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rhtop.taskmanager.ui.fragment.CompanyFragment;

import com.rhtop.taskmanager.R;

//在任务详情界面点击指派人或者关注人后进入ChooseContactActivity(选择联系人界面)
public class ChooseContactActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_contact);
        initView();
    }

    private void initView() {
        CompanyFragment cf = CompanyFragment.newInstance(null, null);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fl_list, cf);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() != 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
