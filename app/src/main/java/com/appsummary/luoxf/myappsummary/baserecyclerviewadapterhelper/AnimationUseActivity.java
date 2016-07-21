package com.appsummary.luoxf.myappsummary.baserecyclerviewadapterhelper;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.appsummary.luoxf.myappsummary.R;
import com.appsummary.luoxf.myappsummary.baserecyclerviewadapterhelper.adapter.QuickAdapter;
import com.appsummary.luoxf.myappsummary.baserecyclerviewadapterhelper.animation.CustomAnimation;
import com.appsummary.luoxf.myappsummary.baserecyclerviewadapterhelper.entity.Status;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jaredrummler.materialspinner.MaterialSpinner;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class AnimationUseActivity extends Activity {
    private RecyclerView mRecyclerView;
    private QuickAdapter mQuickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_use);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();
        initMenu();
    }

    private void initAdapter() {
        mQuickAdapter = new QuickAdapter();
        mQuickAdapter.openLoadAnimation();
        mQuickAdapter.setOnRecyclerViewItemChildClickListener(new BaseQuickAdapter.OnRecyclerViewItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String content = null;
                Status status = (Status) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.tweetAvatar:
                        content = "img:" + status.getUserAvatar();
                        break;
                    case R.id.tweetName:
                        content = "name:" + status.getUserName();
                        break;
                }
                Toast.makeText(AnimationUseActivity.this, content, Toast.LENGTH_LONG).show();
            }
        });
        mRecyclerView.setAdapter(mQuickAdapter);
    }

    private void initMenu() {
        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.spinner);
        spinner.setItems("AlphaIn", "ScaleIn", "SlideInBottom", "SlideInLeft", "SlideInRight", "Custom");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                switch (position) {
                    case 0:
                        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                        break;
                    case 1:
                        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                        break;
                    case 2:
                        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                        break;
                    case 3:
                        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                        break;
                    case 4:
                        mQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
                        break;
                    case 5:
                        mQuickAdapter.openLoadAnimation(new CustomAnimation());
                        break;
                    default:
                        break;
                }
                mRecyclerView.setAdapter(mQuickAdapter);
            }
        });
        MaterialSpinner spinnerFirstOnly = (MaterialSpinner) findViewById(R.id.spinner_first_only);
        spinnerFirstOnly.setItems("isFirstOnly(true)", "isFirstOnly(false)");
        spinnerFirstOnly.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                switch (position) {
                    case 0:
                        mQuickAdapter.isFirstOnly(true);
                        break;
                    case 1:
                        mQuickAdapter.isFirstOnly(false);
                        break;
                    default:
                        break;
                }
                mQuickAdapter.notifyDataSetChanged();
            }
        });
    }

}