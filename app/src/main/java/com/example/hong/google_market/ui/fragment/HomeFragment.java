package com.example.hong.google_market.ui.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hong.google_market.R;
import com.example.hong.google_market.holder.BaseHolder;
import com.example.hong.google_market.holder.HomeHolder;
import com.example.hong.google_market.ui.adapter.MyBaseAdapter;
import com.example.hong.google_market.ui.view.LoadingPage;
import com.example.hong.google_market.utils.UIUtils;

import java.util.ArrayList;

/**
 * Created by hong on 2019/5/27.
 * 首页
 */

public class HomeFragment extends BaseFragment {

    private ArrayList<String> data;

    // 如果加载数据成功, 就回调此方法, 在主线程运行
    @Override
    public View onCreateSuccessView() {
        ListView view = new ListView(UIUtils.getContext());
        view.setAdapter(new HomeAdapter(data));
        view.setDivider(null);
        return view;
    }

    // 运行在子线程,可以直接执行耗时网络操作,先走onLoad，再走onCreateSuccessView
    @Override
    public LoadingPage.ResultState onLoad() {
        data = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            data.add("测试数据:" + i);
        }
        return LoadingPage.ResultState.STATE_SUCCESS;
    }

    class HomeAdapter extends MyBaseAdapter<String> {

        public HomeAdapter(ArrayList<String> data) {
            super(data);
        }

        @Override
        public BaseHolder<String> getHolder() {
            return new HomeHolder();
        }
    }
}