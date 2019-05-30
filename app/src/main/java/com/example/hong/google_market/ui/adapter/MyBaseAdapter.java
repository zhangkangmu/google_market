package com.example.hong.google_market.ui.adapter;


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.hong.google_market.holder.BaseHolder;

import java.util.ArrayList;

/**
 * Created by hong on 2019/5/30.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    private ArrayList<T> data;
    public MyBaseAdapter(ArrayList<T> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size(); // 增加加载更多布局数量
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder<T> holder;
        if (convertView ==null){
            // 1. 加载布局文件
            // 2. 初始化控件 findViewById
            // 3. 打一个标记tag
            holder = getHolder();// 子类返回具体对象
        }else {
            holder = (BaseHolder) convertView.getTag();
        }
        holder.setData(getItem(position));
        return holder.getRootView();
    }

    // 返回当前页面的holder对象, 必须子类实现
    public abstract BaseHolder<T> getHolder();
}
