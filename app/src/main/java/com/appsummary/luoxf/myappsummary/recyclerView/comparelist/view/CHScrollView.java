package com.appsummary.luoxf.myappsummary.recyclerView.comparelist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class CHScrollView extends HorizontalScrollView {

    private CHScrollChangedListener mListener;

    public interface CHScrollChangedListener {
        void setTouchView(CHScrollView view);

        HorizontalScrollView getTouchView();

        void onScrollChanged(int l, int t, int oldl, int oldt);
    }

    public CHScrollView(Context context, AttributeSet attrs, int defStyle, CHScrollChangedListener listener) {
        super(context, attrs, defStyle);
        mListener = listener;
    }

    public void setScrollListener(CHScrollChangedListener listener) {
        mListener = listener;
    }

    public CHScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CHScrollView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mListener != null) {
            mListener.setTouchView(this);
        }
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (mListener != null && mListener.getTouchView() == this) {
            mListener.onScrollChanged(l, t, oldl, oldt);
        } else {
            super.onScrollChanged(l, t, oldl, oldt);
        }
    }
}
