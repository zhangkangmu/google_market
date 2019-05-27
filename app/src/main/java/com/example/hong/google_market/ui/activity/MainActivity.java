package com.example.hong.google_market.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.hong.google_market.R;
import com.example.hong.google_market.ui.fragment.BaseFragment;
import com.example.hong.google_market.ui.fragment.FragmentFactory;
import com.example.hong.google_market.ui.view.PagerTab;
import com.example.hong.google_market.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity {

    @BindView(R.id.pager_tab)
    PagerTab pagerTab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private MyAdapter myAdapter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        initPagerTab();
    }

    private void initPagerTab() {
        myAdapter = new MyAdapter(getSupportFragmentManager());
        viewpager.setAdapter(myAdapter);
        pagerTab.setViewPager(viewpager);
    }

    class MyAdapter extends FragmentPagerAdapter {
        private String[] mTabNames;

        public MyAdapter(FragmentManager fm) {
            super(fm);
            mTabNames = UIUtils.getStringArray(R.array.tab_names);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabNames[position];
        }

        @Override
        public Fragment getItem(int position) {
            BaseFragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        @Override
        public int getCount() {
            return mTabNames.length;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
