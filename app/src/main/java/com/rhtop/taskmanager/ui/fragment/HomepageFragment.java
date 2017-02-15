package com.rhtop.taskmanager.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.rhtop.taskmanager.R;
import com.rhtop.taskmanager.ui.activity.TaskListActivity;
import com.rhtop.taskmanager.ui.adapter.TaskCategoryAdapter;


//首页Fragment
public class HomepageFragment extends Fragment implements AdapterView.OnItemClickListener{
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    Context mContext;
    GridView gvTaskCategory;
    TaskCategoryAdapter mAdapter;
    private static final int[] imgResIds = {R.drawable.task_started_2x, R.drawable.task_focused_2x, R.drawable.task_responsible_2x,
            R.drawable.task_completed_2x, R.drawable.task_overdue_2x};
    private static final String[] data = {"任务发起","任务关注","任务负责","任务完成","任务逾期"};
    public HomepageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomepageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomepageFragment newInstance(String param1, String param2) {
        HomepageFragment fragment = new HomepageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        gvTaskCategory = (GridView) view.findViewById(R.id.gv_task_category);
        mAdapter = new TaskCategoryAdapter(mContext, R.layout.layout_task_category_item, data, imgResIds);
        gvTaskCategory.setAdapter(mAdapter);
        gvTaskCategory.setOnItemClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), TaskListActivity.class);
        startActivity(intent);
    }
}
