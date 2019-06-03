package com.example.hong.google_market.ui.fragment;

import android.os.SystemClock;
import android.view.View;
import android.widget.ListView;

import com.example.hong.google_market.domain.AppInfo;
import com.example.hong.google_market.holder.BaseHolder;
import com.example.hong.google_market.holder.HomeHolder;
import com.example.hong.google_market.http.protocol.HomeProtocol;
import com.example.hong.google_market.ui.adapter.MyBaseAdapter;
import com.example.hong.google_market.ui.view.LoadingPage;
import com.example.hong.google_market.utils.UIUtils;

import java.util.ArrayList;

/**
 * Created by hong on 2019/5/27.
 * 首页
 */

public class HomeFragment extends BaseFragment {

    private ArrayList<AppInfo> data;

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
//        data = new ArrayList<String>();
//        for (int i = 0; i < 20; i++) {
//            data.add("测试数据:" + i);
//        }
        // }
        HomeProtocol protocol = new HomeProtocol();
        data = protocol.getData(0);// 加载第一页数据
        //check这个方法在基类里
        return check(data);// 校验数据并返回
    }


    class HomeAdapter extends MyBaseAdapter<AppInfo> {

        private int listSize;

        public HomeAdapter(ArrayList<AppInfo> data) {
            super(data);
        }

        // 此方法在子线程调用
        @Override
        public ArrayList<AppInfo> onLoadMore() {
//             ArrayList<String> moreData = new ArrayList<String>();
//             for(int i=0;i<20;i++) {
//             moreData.add("测试更多数据:" + i);
//             }
//
//             SystemClock.sleep(2000);
            HomeProtocol protocol = new HomeProtocol();
            // 20, 40, 60....
            // 下一页数据的位置 等于 当前集合大小
            ArrayList<AppInfo> moreData = protocol.getData(getListSize());
            return moreData;// 校验数据并返回
        }

        @Override
        public BaseHolder<AppInfo> getHolder() {
            return new HomeHolder();
        }

    }
}