/*
 * Copyright (C) 2016 venshine.cn@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.appsummary.luoxf.myappsummary.animation.goodview;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.appsummary.luoxf.myappsummary.BaseActivity;
import com.appsummary.luoxf.myappsummary.R;
import com.appsummary.luoxf.myappsummary.animation.AnimationMainActivity;


/**
 * Demo
 *
 * @author venshine
 */
public class GoodViewActivity extends BaseActivity {

    GoodView mGoodView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGoodView = new GoodView(this);
        initToolBarWithBack(AnimationMainActivity.ITEMSTR_GOODVIEW);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_goodview_main;
    }

    public void good(View view) {
        ((ImageView) view).setImageResource(R.drawable.good_checked);
        mGoodView.setText("+1");
        mGoodView.show(view);
    }

    public void good2(View view) {
        ((ImageView) view).setImageResource(R.drawable.good_checked);
        mGoodView.setImage(getResources().getDrawable(R.drawable.good_checked));
        mGoodView.show(view);
    }

    public void collection(View view) {
        ((ImageView) view).setImageResource(R.drawable.collection_checked);
        mGoodView.setTextInfo("收藏成功", Color.parseColor("#f66467"), 12);
        mGoodView.show(view);
    }

    public void bookmark(View view) {
        ((ImageView) view).setImageResource(R.drawable.bookmark_checked);
        mGoodView.setTextInfo("收藏成功", Color.parseColor("#ff941A"), 12);
        mGoodView.show(view);
    }

    public void reset(View view) {
        ((ImageView) findViewById(R.id.good)).setImageResource(R.drawable.good);
        ((ImageView) findViewById(R.id.good2)).setImageResource(R.drawable.good);
        ((ImageView) findViewById(R.id.collection)).setImageResource(R.drawable.collection);
        ((ImageView) findViewById(R.id.bookmark)).setImageResource(R.drawable.bookmark);
        mGoodView.reset();
    }

}
