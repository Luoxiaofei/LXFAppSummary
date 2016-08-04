package com.appsummary.luoxf.myappsummary.recyclerView.comparelist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.appsummary.luoxf.myappsummary.R;
import com.appsummary.luoxf.myappsummary.recyclerView.comparelist.model.HeaderModel;
import com.appsummary.luoxf.myappsummary.recyclerView.comparelist.model.RightModel;
import com.appsummary.luoxf.myappsummary.recyclerView.comparelist.view.CHScrollView;
import com.appsummary.luoxf.mylibrary.Logger;

import java.util.ArrayList;
import java.util.List;

public class CompareSectionedAdapter extends SectionedBaseAdapter {

    private List<HeaderModel> headerList = new ArrayList<>();
    private List<List<RightModel>> listItemList = new ArrayList<>();
    private ViewScrollListener mListener;

    public interface ViewScrollListener {
        void addScrollView(CHScrollView view);
    }

    public CompareSectionedAdapter(ViewScrollListener listener) {
        mListener = listener;
    }

    @Override
    public Object getItem(int section, int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int section, int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getSectionCount() {
        return headerList.size();
    }

    @Override
    public int getCountForSection(int section) {
        return listItemList.get(section).size();
    }

    @Override
    public View getItemView(int section, int position, View convertView, ViewGroup parent) {
        ViewHold viewHold;
        if (convertView == null) {
            viewHold = new ViewHold();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_compare_item, null);
            viewHold.textView0 = (TextView) convertView.findViewById(R.id.right_item_textview0);
            viewHold.textView1 = (TextView) convertView.findViewById(R.id.right_item_textview1);
            viewHold.textView2 = (TextView) convertView.findViewById(R.id.right_item_textview2);
            viewHold.textView3 = (TextView) convertView.findViewById(R.id.right_item_textview3);
            viewHold.textView4 = (TextView) convertView.findViewById(R.id.right_item_textview4);
            viewHold.textView5 = (TextView) convertView.findViewById(R.id.right_item_textview5);
            if (mListener != null) {
                CHScrollView view = (CHScrollView) convertView.findViewById(R.id.item_scroll);

                mListener.addScrollView(view);
            }
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        List<RightModel> tmpItemList = listItemList.get(section);
        if (tmpItemList.isEmpty()) {
            Logger.e("item list is null or empty");
        } else {
            RightModel tmpModel = tmpItemList.get(position);
            viewHold.textView0.setText(tmpModel.getText0());
            viewHold.textView1.setText(tmpModel.getText1());
            viewHold.textView2.setText(tmpModel.getText2());
            viewHold.textView3.setText(tmpModel.getText3());
            viewHold.textView4.setText(tmpModel.getText4());
            viewHold.textView5.setText(tmpModel.getText5());
        }
        if (position == 0) {
            setTextFontColor(viewHold, parent.getContext().getResources().getColor(R.color.compare_detail_right_first_font_color));
        } else {
            setTextFontColor(viewHold, parent.getContext().getResources().getColor(R.color.compare_detail_label_check_detail_color));
        }
        if (position % 2 == 0) {
            setBackGroundColor(viewHold, parent.getContext().getResources().getColor(R.color.white));
        } else {
            setBackGroundColor(viewHold, parent.getContext().getResources().getColor(R.color.compare_detail_right_span_item_bg_color));
        }

        return convertView;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        LinearLayout layout;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) inflator.inflate(R.layout.layout_spnner_header, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        TextView leftTv = (TextView) layout.findViewById(R.id.header_left);
        TextView rightTv = (TextView) layout.findViewById(R.id.header_right);
        HeaderModel model = headerList.get(section);
        if (model != null) {
            leftTv.setText(model.getLeftStr());
            rightTv.setText(model.getRightStr());
        } else {
            leftTv.setText("");
            rightTv.setText("");
        }

        return layout;
    }

    private void setTextFontColor(ViewHold viewHold, int color) {
        viewHold.textView1.setTextColor(color);
        viewHold.textView2.setTextColor(color);
        viewHold.textView3.setTextColor(color);
        viewHold.textView4.setTextColor(color);
        viewHold.textView5.setTextColor(color);
    }

    private void setBackGroundColor(ViewHold viewHold, int color) {
        viewHold.textView1.setBackgroundColor(color);
        viewHold.textView2.setBackgroundColor(color);
        viewHold.textView3.setBackgroundColor(color);
        viewHold.textView4.setBackgroundColor(color);
        viewHold.textView5.setBackgroundColor(color);
    }

    public void alertData(List<HeaderModel> headerList, List<List<RightModel>> listItemList) {
        this.listItemList.clear();
        this.listItemList.addAll(listItemList);
        this.headerList.clear();
        this.headerList.addAll(headerList);
        notifyDataSetChanged();
    }

    static class ViewHold {
        TextView textView0, textView1, textView2, textView3, textView4, textView5;
    }
}
