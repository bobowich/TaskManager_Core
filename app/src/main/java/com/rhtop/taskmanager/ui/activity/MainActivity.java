package com.rhtop.taskmanager.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.rhtop.taskmanager.R;
import com.rhtop.taskmanager.ui.adapter.MainFragmentPagerAdapter;
import com.rhtop.taskmanager.ui.fragment.CountFragment;
import com.rhtop.taskmanager.ui.fragment.HomepageFragment;
import com.rhtop.taskmanager.ui.fragment.PandectFragment;
import com.rhtop.taskmanager.ui.fragment.SelfFragment;
import com.rhtop.taskmanager.ui.widget.TitleBarLayout;

import java.util.ArrayList;
import java.util.List;

//主界面
public class MainActivity extends BaseActivity {

    private TitleBarLayout titleBar;
    private ViewPager vpMain;
    private List<Fragment> mFragmentList;
    private MainFragmentPagerAdapter fragmentAdapter;
    private TabLayout tlNavigation;
    private TabLayout.Tab tabOne,tabTwo,tabThree,tabFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragList();
        initView();
        initTabs();
    }

    private void initFragList() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(0, new HomepageFragment());
        mFragmentList.add(1, new CountFragment());
        mFragmentList.add(2, new PandectFragment());
        mFragmentList.add(3, new SelfFragment());
    }

    private void initTabs() {
        tabOne = tlNavigation.getTabAt(0);
        tabTwo = tlNavigation.getTabAt(1);
        tabThree = tlNavigation.getTabAt(2);
        tabFour = tlNavigation.getTabAt(3);
        tabOne.setIcon(R.drawable.selector_homepage);
        tabTwo.setIcon(R.drawable.selector_count);
        tabThree.setIcon(R.drawable.selector_pandect);
        tabFour.setIcon(R.drawable.select_self);
    }

    private void initView() {
        titleBar = (TitleBarLayout) findViewById(R.id.title_bar);
        vpMain = (ViewPager) findViewById(R.id.vp_main);
        fragmentAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        vpMain.setAdapter(fragmentAdapter);
        tlNavigation = (TabLayout) findViewById(R.id.tl_navigation);
        tlNavigation.setupWithViewPager(vpMain);
    }
}
