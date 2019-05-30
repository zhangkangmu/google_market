package com.example.hong.google_market.holder;

import android.view.View;
import android.widget.TextView;

import com.example.hong.google_market.R;
import com.example.hong.google_market.utils.UIUtils;

/**
 * 首页holder
 * Created by hong on 2019/5/30.
 */

public class HomeHolder extends BaseHolder<String> {
    private TextView tvContent;

    @Override
    public View initView() {
        View view = UIUtils.inflate(R.layout.list_item_home);
        tvContent = view.findViewById(R.id.tv_content);
        return view;
    }

    @Override
    public void refreshView(String data) {
        tvContent.setText(data);
    }
}
