package com.appsummary.luoxf.myappsummary.baserecyclerviewadapterhelper;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.appsummary.luoxf.myappsummary.R;
import com.appsummary.luoxf.myappsummary.baserecyclerviewadapterhelper.adapter.MultipleItemQuickAdapter;
import com.appsummary.luoxf.myappsummary.baserecyclerviewadapterhelper.data.DataServer;


/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MultipleItemUseActivity extends Activity {
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_use);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MultipleItemQuickAdapter multipleItemAdapter = new MultipleItemQuickAdapter(this, DataServer.getMultipleItemData());
        mRecyclerView.setAdapter(multipleItemAdapter);
    }
}
