/*
 * Copyright (C) 2015 Antonio Leiva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.appsummary.luoxf.myappsummary.recyclerView;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.appsummary.luoxf.myappsummary.BaseActivity;
import com.appsummary.luoxf.myappsummary.R;
import com.appsummary.luoxf.myappsummary.recyclerView.fastscroll.RecyclerFastScrollFragment;
import com.appsummary.luoxf.mylibrary.swipbackhelper.SwipeBackHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class RecyclerViewTabActivity extends BaseActivity {

    @BindView(R.id.tabs)
    TabLayout mTabs;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBarWithBack(R.string.sub_summary_recycler_tab);
        initViewPager();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_recyclerview_main;
    }


    private void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerFastScrollFragment());
        fragments.add(new RecyclerFastScrollFragment());
        fragments.add(new RecyclerFastScrollFragment());
        fragments.add(new RecyclerFastScrollFragment());

        List<String> titles = new ArrayList<>();
        titles.add(getString(R.string.tab_recycler_fast_scroll));
        titles.add("RecyclerGrid");
        titles.add("RecyclerStaggered");
        titles.add("Nestedscroll");

        mTabs.addTab(mTabs.newTab().setText(titles.get(0)));
        mTabs.addTab(mTabs.newTab().setText(titles.get(1)));
        mTabs.addTab(mTabs.newTab().setText(titles.get(2)));
        mTabs.addTab(mTabs.newTab().setText(titles.get(3)));
        RecyclerMainTabAdapter mAdapter = new RecyclerMainTabAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(mAdapter);
        mTabs.setupWithViewPager(mViewPager);
        mTabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabs.setTabsFromPagerAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    //让RollPagerView可以处理事件，而RollPagerView处不可以滑动环比，其他没有View处理事件的区域可以正常滑动关闭。
                    SwipeBackHelper.getCurrentPage(RecyclerViewTabActivity.this).setDisallowInterceptTouchEvent(false);
                }else {
                    SwipeBackHelper.getCurrentPage(RecyclerViewTabActivity.this).setDisallowInterceptTouchEvent(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
