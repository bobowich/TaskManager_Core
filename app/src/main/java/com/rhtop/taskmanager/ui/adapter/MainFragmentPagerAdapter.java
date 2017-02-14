package com.rhtop.taskmanager.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bobowich
 * Time: 2017/2/14.
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    FragmentManager mFragmentManager;
    List<Fragment> mFragments;
    private static final String titles[] = {"首页", "统计", "总览", "我的"};

    public MainFragmentPagerAdapter(FragmentManager fm,List<Fragment> fragmentMap) {
        super(fm);
        mFragmentManager = fm;
        mFragments = fragmentMap;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
