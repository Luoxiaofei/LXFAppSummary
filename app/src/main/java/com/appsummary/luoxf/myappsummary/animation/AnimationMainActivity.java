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

package com.appsummary.luoxf.myappsummary.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.appsummary.luoxf.myappsummary.BaseActivity;
import com.appsummary.luoxf.myappsummary.R;
import com.appsummary.luoxf.myappsummary.RecyclerViewAdapter;
import com.appsummary.luoxf.myappsummary.animation.explosionfield.ExplosionFieldActivity;
import com.appsummary.luoxf.myappsummary.animation.goodview.GoodViewActivity;
import com.appsummary.luoxf.myappsummary.animation.loading.LoadingMainActivity;
import com.appsummary.luoxf.myappsummary.animation.pm25.PM25Activity;
import com.appsummary.luoxf.myappsummary.animation.pulltomakesoup.PullToMakeSoupActivity;
import com.appsummary.luoxf.myappsummary.animation.textexpand.TextViewExpandActivity;
import com.appsummary.luoxf.myappsummary.animation.ticker.TickerMainActivity;
import com.appsummary.luoxf.myappsummary.baserecyclerviewadapterhelper.HomeActivity;
import com.appsummary.luoxf.myappsummary.model.AnimationMainListItemModel;
import com.appsummary.luoxf.myappsummary.recyclerView.RecyclerMainTabAdapter;
import com.appsummary.luoxf.myappsummary.recyclerView.fastscroll.RecyclerFastScrollFragment;
import com.appsummary.luoxf.myappsummary.recyclerView.fastscroll.Views.FastScrollRecyclerView;
import com.appsummary.luoxf.mylibrary.swipbackhelper.SwipeBackHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;


public class AnimationMainActivity extends BaseActivity {
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    public static final String ITEMSTR_PULLTOMAKESOUP = "PullToMakeSoup";
    public static final String ITEMSTR_GOODVIEW = "GoodView";
    public static final String ITEMSTR_PM25 = "PM2.5";
    public static final String ITEMSTR_EXPLOSION = "explosionFiled";
    public static final String ITEMSTR_LOADING = "Loading";
    public static final String ITEMSTR_RECYCLER = "Recycler";
    public static final String ITEMSTR_TICKER = "Ticker";
    public static final String ITEMSTR_TEXT_EXPAND = "TextViewExpand";
    private static List<Integer> colorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBarWithBack(R.string.title_animation);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        RecyclerAdapter adapter = new RecyclerAdapter(this);
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                switch (data) {
                    case ITEMSTR_PULLTOMAKESOUP:
                        startActivity(new Intent(AnimationMainActivity.this, PullToMakeSoupActivity.class));
                        break;
                    case ITEMSTR_GOODVIEW:
                        startActivity(new Intent(AnimationMainActivity.this, GoodViewActivity.class));
                        break;
                    case ITEMSTR_PM25:
                        startActivity(new Intent(AnimationMainActivity.this, PM25Activity.class));
                        break;
                    case ITEMSTR_EXPLOSION:
                        startActivity(new Intent(AnimationMainActivity.this, ExplosionFieldActivity.class));
                        break;
                    case ITEMSTR_LOADING:
                        startActivity(new Intent(AnimationMainActivity.this, LoadingMainActivity.class));
                        break;
                    case ITEMSTR_RECYCLER:
                        startActivity(new Intent(AnimationMainActivity.this, HomeActivity.class));
                        break;
                    case ITEMSTR_TICKER:
                        startActivity(new Intent(AnimationMainActivity.this, TickerMainActivity.class));
                        break;
                    case ITEMSTR_TEXT_EXPAND:
                        startActivity(new Intent(AnimationMainActivity.this, TextViewExpandActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
        colorList.add(R.color.saffron);
        colorList.add(R.color.eggplant);
        colorList.add(R.color.sienna);
        colorList.add(R.color.accent_translucent);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_animation_main_recyclerview;
    }

    public interface MyItemClickListener {
        void onItemClick(View view, String data);
    }


    private static class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements View.OnClickListener {
        private List<AnimationMainListItemModel> allItems = new ArrayList<>();
        private MyItemClickListener mOnItemClickListener = null;
        private Context mContext;

        private RecyclerAdapter(Context context) {
            mContext = context;
            initListItem();
        }

        private void initListItem() {
            initItemModel(ITEMSTR_PULLTOMAKESOUP, mContext.getString(R.string.sub_summary_pull_to_make_soup));
            initItemModel(ITEMSTR_GOODVIEW, mContext.getString(R.string.sub_summary_good_view));
            initItemModel(ITEMSTR_PM25, mContext.getString(R.string.sub_summary_pm25));
            initItemModel(ITEMSTR_EXPLOSION, mContext.getString(R.string.sub_summary_explosion));
            initItemModel(ITEMSTR_LOADING, mContext.getString(R.string.sub_summary_loading));
            initItemModel(ITEMSTR_RECYCLER, mContext.getString(R.string.sub_summary_recycler));
            initItemModel(ITEMSTR_TICKER, mContext.getString(R.string.sub_summary_ticker));
            initItemModel(ITEMSTR_TEXT_EXPAND, mContext.getString(R.string.title_textview_expand));

        }

        private void initItemModel(String title, String subtitle) {
            AnimationMainListItemModel model = new AnimationMainListItemModel();
            model.setTitle(title);
            model.setSummary(subtitle);
            allItems.add(model);
        }


        public void setOnItemClickListener(MyItemClickListener listener) {
            this.mOnItemClickListener = listener;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animation_main_recycler_item, parent, false);
            ViewHolder vh = new ViewHolder(view);
            //将创建的View注册点击事件
            view.setOnClickListener(this);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.text.setText(allItems.get(position).getTitle());
            holder.textSub.setText(allItems.get(position).getSummary());
            //将数据保存在itemView的Tag中，以便点击时进行获取
            holder.itemView.setTag(allItems.get(position).getTitle());
            Random random = new Random();
            int index = random.nextInt(colorList.size());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                holder.mCardView.setBackgroundColor(mContext.getResources().getColor(colorList.get(index), null));
            } else {
                //设置背景后　和　swipeBackLayout配合时候会ＦＣ
                holder.mCardView.setBackgroundColor(mContext.getResources().getColor(colorList.get(index)));
            }
        }

        @Override
        public int getItemCount() {
            return allItems.size();
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                //注意这里使用getTag方法获取数据
                mOnItemClickListener.onItemClick(v, (String) v.getTag());
            }
        }


        static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView text;
            public CardView mCardView;
            public TextView textSub;

            public ViewHolder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.text);
                mCardView = (CardView) itemView.findViewById(R.id.cardview);
                textSub = (TextView) itemView.findViewById(R.id.text_sub);
            }
        }
    }

}
