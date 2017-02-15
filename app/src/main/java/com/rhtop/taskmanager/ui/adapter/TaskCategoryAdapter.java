package com.rhtop.taskmanager.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rhtop.taskmanager.R;

/**
 * Created by bobowich
 * Time: 2017/2/15.
 */

public class TaskCategoryAdapter extends BaseAdapter {
    Context mContext;
    int mLayoutResId;
    String[] mData;
    int[] mImgResId;

    public TaskCategoryAdapter(Context context,int layotResId,String[] data,int[] imgResIds)  {
        mContext = context;
        mLayoutResId = layotResId;
        mData = data;
        mImgResId = imgResIds;
    }

    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mLayoutResId, null);
            holder = new Holder();
            holder.mImageView = (ImageView) convertView.findViewById(R.id.iv_task_category);
            holder.mTextView = (TextView) convertView.findViewById(R.id.tv_task_category);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.mImageView.setImageResource(mImgResId[position]);
        holder.mTextView.setText(mData[position]);
        
        return convertView;
    }

    private static class Holder{
        TextView mTextView;
        ImageView mImageView;
    }
}
