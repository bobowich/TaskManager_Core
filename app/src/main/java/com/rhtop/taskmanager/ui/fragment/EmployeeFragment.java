package com.rhtop.taskmanager.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rhtop.taskmanager.R;

/**
 * Created by bobowich
 * Time: 2017/2/13.
 */

public class EmployeeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee,container,false);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
