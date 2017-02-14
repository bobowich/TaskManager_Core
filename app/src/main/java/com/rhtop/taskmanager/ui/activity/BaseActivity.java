package com.rhtop.taskmanager.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.rhtop.taskmanager.ui.widget.TitleBarLayout;

/**
 * Created by bobowich
 * Time: 2017/2/14.
 */

public class BaseActivity extends AppCompatActivity implements TitleBarLayout.TitleBarListener{


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void onBackClick() {
        finish();
    }

    @Override
    public void onFuncClick() {

    }
}
