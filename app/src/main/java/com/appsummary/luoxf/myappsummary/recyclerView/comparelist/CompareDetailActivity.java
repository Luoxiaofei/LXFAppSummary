package com.appsummary.luoxf.myappsummary.recyclerView.comparelist;

import android.os.Bundle;
import android.widget.HorizontalScrollView;

import com.appsummary.luoxf.myappsummary.BaseActivity;
import com.appsummary.luoxf.myappsummary.R;
import com.appsummary.luoxf.myappsummary.recyclerView.comparelist.adapter.CompareSectionedAdapter;
import com.appsummary.luoxf.myappsummary.recyclerView.comparelist.model.HeaderModel;
import com.appsummary.luoxf.myappsummary.recyclerView.comparelist.model.RightModel;
import com.appsummary.luoxf.myappsummary.recyclerView.comparelist.view.CHScrollView;
import com.appsummary.luoxf.myappsummary.recyclerView.comparelist.view.PinnedHeaderListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CompareDetailActivity extends BaseActivity implements CompareSectionedAdapter.ViewScrollListener, CHScrollView.CHScrollChangedListener {
    @BindView(R.id.scroll_list)
    PinnedHeaderListView mListView;
    public HorizontalScrollView mTouchView;
    protected List<CHScrollView> mHScrollViews = new ArrayList<>();
    private List<HeaderModel> headers = new ArrayList<>();
    private List<List<RightModel>> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBarWithBack(R.string.title_compare_detail);
        initViews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.compare_scroll;
    }

    private void initViews() {
        CHScrollView headerScroll = (CHScrollView) findViewById(R.id.item_scroll_title);
        addScrollView(headerScroll);

        initRightData();

        CompareSectionedAdapter adapter = new CompareSectionedAdapter(this);
        mListView.setAdapter(adapter);
        adapter.alertData(headers, models);
    }

    private void initRightData() {
        headers.add(new HeaderModel("基本信息", "-无"));
        headers.add(new HeaderModel("基本信息1", "-无"));
        headers.add(new HeaderModel("基本信息2", "-无"));
        headers.add(new HeaderModel("基本信息3", "-无"));
        List<RightModel> itemModel1 = new ArrayList<>();
        itemModel1.add(new RightModel("参考价", "10732元", "13400元", "58000元", "444", "555"));
        itemModel1.add(new RightModel("保障区域", "中国大陆", "亚洲", "全球", "444", "555"));
        itemModel1.add(new RightModel("保障金额", "400万", "800万", "1000万", "444", "555"));
        itemModel1.add(new RightModel(getString(R.string.compare_detail_left_label_baoxianjin), "年限额400万", "年限额800万", "年限额1000万", "444", "555"));
        itemModel1.add(new RightModel("床位费", "标准病房", "标准病房", "标准病房", "444", "555"));
        itemModel1.add(new RightModel("膳食费", "全额理赔", "全额理赔", "全额理赔", "444", "555"));
        itemModel1.add(new RightModel("护理费", "全额理赔", "全额理赔", "全额理赔", "444", "555"));
        itemModel1.add(new RightModel("医生费", "全额理赔", "全额理赔", "全额理赔", "全额理赔", "全额理赔"));
        itemModel1.add(new RightModel("手术费", "年限10万", "年限20万", "年限30万", "年限10万", "年限10万"));
        itemModel1.add(new RightModel("激素代替", "————", "年限6万", "年限12万", "年限6万", "————"));
        itemModel1.add(new RightModel("治疗费", "————", "————", "————", "————", "年限6万"));
        models.add(itemModel1);


        List<RightModel> itemModel2 = new ArrayList<>();
        itemModel2.add(new RightModel("参考价", "10732元", "13400元", "58000元", "444", "555"));
        itemModel2.add(new RightModel("保障区域", "中国大陆", "亚洲", "全球", "444", "555"));
        itemModel2.add(new RightModel("保障金额", "400万", "800万", "1000万", "444", "555"));
        itemModel2.add(new RightModel(getString(R.string.compare_detail_left_label_baoxianjin), "年限额400万", "年限额800万", "年限额1000万", "444", "555"));
        itemModel2.add(new RightModel("护理费", "全额理赔", "全额理赔", "全额理赔", "444", "555"));
        itemModel2.add(new RightModel("医生费", "全额理赔", "全额理赔", "全额理赔", "全额理赔", "全额理赔"));
        itemModel2.add(new RightModel("手术费", "年限10万", "年限20万", "年限30万", "年限10万", "年限10万"));
        models.add(itemModel2);

        List<RightModel> itemModel3 = new ArrayList<>();
        itemModel3.add(new RightModel(getString(R.string.compare_detail_left_label_baoxianjin), "年限额400万", "年限额800万", "年限额1000万", "444", "555"));
        itemModel3.add(new RightModel("床位费", "标准病房", "标准病房", "标准病房", "444", "555"));
        itemModel3.add(new RightModel("膳食费", "全额理赔", "全额理赔", "全额理赔", "444", "555"));
        itemModel3.add(new RightModel("护理费", "全额理赔", "全额理赔", "全额理赔", "444", "555"));
        itemModel3.add(new RightModel("医生费", "全额理赔", "全额理赔", "全额理赔", "全额理赔", "全额理赔"));
        itemModel3.add(new RightModel("手术费", "年限10万", "年限20万", "年限30万", "年限10万", "年限10万"));
        itemModel3.add(new RightModel("激素代替", "————", "年限6万", "年限12万", "年限6万", "————"));
        itemModel3.add(new RightModel("治疗费", "————", "————", "————", "————", "年限6万"));
        itemModel3.add(new RightModel("治疗费", "————", "————", "————", "————", "————"));
        itemModel3.add(new RightModel("治疗费", "————", "222", "————", "444", "————"));
        itemModel3.add(new RightModel("治疗费", "————", "————", "————", "————", "555"));
        itemModel3.add(new RightModel("治疗费", "————", "————", "————", "————", "555"));
        models.add(itemModel3);

        List<RightModel> itemModel4 = new ArrayList<>();
        itemModel4.add(new RightModel(getString(R.string.compare_detail_left_label_baoxianjin), "年限额400万", "年限额800万", "年限额1000万", "444", "555"));
        itemModel4.add(new RightModel("床位费", "标准病房", "标准病房", "标准病房", "444", "555"));
        itemModel4.add(new RightModel("膳食费", "全额理赔", "全额理赔", "全额理赔", "444", "555"));
        itemModel4.add(new RightModel("护理费", "全额理赔", "全额理赔", "全额理赔", "444", "555"));
        itemModel4.add(new RightModel("医生费", "全额理赔", "全额理赔", "全额理赔", "全额理赔", "全额理赔"));
        itemModel4.add(new RightModel("手术费", "年限10万", "年限20万", "年限30万", "年限10万", "年限10万"));
        itemModel4.add(new RightModel("激素代替", "————", "年限6万", "年限12万", "年限6万", "————"));
        itemModel4.add(new RightModel("治疗费", "————", "————", "————", "————", "年限6万"));
        itemModel4.add(new RightModel("治疗费", "————", "————", "————", "————", "————"));
        itemModel4.add(new RightModel("治疗费", "————", "222", "————", "444", "————"));
        models.add(itemModel3);
    }

    @Override
    public void setTouchView(CHScrollView view) {
        mTouchView = view;
    }

    @Override
    public HorizontalScrollView getTouchView() {
        return mTouchView;
    }

    @Override
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        for (CHScrollView scrollView : mHScrollViews) {
            if (mTouchView != scrollView)
                scrollView.smoothScrollTo(l, t);
        }
    }

    @Override
    public void addScrollView(final CHScrollView view) {
        if (!mHScrollViews.isEmpty()) {
            int size = mHScrollViews.size();
            view.setScrollListener(this);
            CHScrollView scrollView = mHScrollViews.get(size - 1);
            final int scrollX = scrollView.getScrollX();
            if (scrollX != 0) {
                mListView.post(new Runnable() {
                    @Override
                    public void run() {
                        view.scrollTo(scrollX, 0);
                    }
                });
            }
        }
        mHScrollViews.add(view);
    }
}