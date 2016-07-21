package com.appsummary.luoxf.myappsummary.navigationtabstrip;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.appsummary.luoxf.myappsummary.BaseActivity;
import com.appsummary.luoxf.myappsummary.R;

import butterknife.BindView;

/**
 * Created by GIGAMOLE on 28.03.2016.
 */
public class NavigationTabStripActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager mViewPager;
    @BindView(R.id.nts_top)
    NavigationTabStrip mTopNavigationTabStrip;
    @BindView(R.id.nts_center)
    NavigationTabStrip mCenterNavigationTabStrip;
    @BindView(R.id.nts_bottom)
    NavigationTabStrip mBottomNavigationTabStrip;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUI();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_navigation_tab_strip_main;
    }

    private void setUI() {
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(final View view, final Object object) {
                return view.equals(object);
            }

            @Override
            public void destroyItem(final View container, final int position, final Object object) {
                ((ViewPager) container).removeView((View) object);
            }

            @Override
            public Object instantiateItem(final ViewGroup container, final int position) {
                final View view = new View(getBaseContext());
                container.addView(view);
                return view;
            }
        });

        mTopNavigationTabStrip.setTabIndex(1, true);
        mCenterNavigationTabStrip.setViewPager(mViewPager, 1);
        mBottomNavigationTabStrip.setTabIndex(1, true);

//        final NavigationTabStrip navigationTabStrip = (NavigationTabStrip) findViewById(R.id.nts);
//        navigationTabStrip.setTitles("Nav", "Tab", "Strip");
//        navigationTabStrip.setTabIndex(0, true);
//        navigationTabStrip.setTitleSize(15);
//        navigationTabStrip.setStripColor(Color.RED);
//        navigationTabStrip.setStripWeight(6);
//        navigationTabStrip.setStripFactor(2);
//        navigationTabStrip.setStripType(NavigationTabStrip.StripType.LINE);
//        navigationTabStrip.setStripGravity(NavigationTabStrip.StripGravity.BOTTOM);
//        navigationTabStrip.setTypeface("fonts/typeface.ttf");
//        navigationTabStrip.setCornersRadius(3);
//        navigationTabStrip.setAnimationDuration(300);
//        navigationTabStrip.setInactiveColor(Color.GRAY);
//        navigationTabStrip.setActiveColor(Color.WHITE);
//        navigationTabStrip.setOnPageChangeListener(...);
//        navigationTabStrip.setOnTabStripSelectedIndexListener(...);
    }
}
