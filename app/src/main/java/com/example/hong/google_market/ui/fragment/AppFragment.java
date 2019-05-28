package com.example.hong.google_market.ui.fragment;

import android.view.View;

import com.example.hong.google_market.ui.view.LoadingPage;

/**
 * Created by hong on 2019/5/27.
 *  * 应用
 */

public class AppFragment extends BaseFragment {
    @Override
    public View onCreateSuccessView() {
        return null;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_ERROR;
    }
}
