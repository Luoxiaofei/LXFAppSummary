package com.appsummary.luoxf.myappsummary.animation.loading;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.appsummary.luoxf.myappsummary.BaseActivity;
import com.appsummary.luoxf.myappsummary.R;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVBattery;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVBlock;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVChromeLogo;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVCircular;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVCircularCD;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVCircularJump;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVCircularRing;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVCircularSmile;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVCircularZoom;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVEatBeans;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVFinePoiStar;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVGears;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVGearsTwo;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVGhost;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVLineWithText;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVNews;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVPlayBall;
import com.appsummary.luoxf.myappsummary.animation.loading.view.LVWifi;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;


public class LoadingMainActivity extends BaseActivity {

    @BindView(R.id.lv_playball)
    LVPlayBall mLVPlayBall;
    @BindView(R.id.lv_circularring)
    LVCircularRing mLVCircularRing;
    @BindView(R.id.lv_circular)
    LVCircular mLVCircular;
    @BindView(R.id.lv_circularJump)
    LVCircularJump mLVCircularJump;
    @BindView(R.id.lv_circularZoom)
    LVCircularZoom mLVCircularZoom;
    @BindView(R.id.lv_linetext)
    LVLineWithText mLVLineWithText;
    @BindView(R.id.lv_eatBeans)
    LVEatBeans mLVEatBeans;
    @BindView(R.id.lv_circularCD)
    LVCircularCD mLVCircularCD;
    @BindView(R.id.lv_circularSmile)
    LVCircularSmile mLVCircularSmile;
    @BindView(R.id.lv_gears)
    LVGears mLVGears;
    @BindView(R.id.lv_gears_two)
    LVGearsTwo mLVGearsTwo;
    @BindView(R.id.lv_finePoiStar)
    LVFinePoiStar mLVFinePoiStar;
    @BindView(R.id.lv_chromeLogo)
    LVChromeLogo mLVChromeLogo;
    @BindView(R.id.lv_battery)
    LVBattery mLVBattery;
    @BindView(R.id.lv_wifi)
    LVWifi mLVWifi;
    @BindView(R.id.lv_news)
    LVNews mLVNews;
    @BindView(R.id.lv_block)
    LVBlock mLVBlock;
    @BindView(R.id.lv_ghost)
    LVGhost mLVGhost;
    int mValueLVLineWithText = 0;
    int mValueLVNews = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLVBattery.setValue(50);
        mLVBattery.setShowNum(false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_loading_main;
    }

    public void startAnim(View v) {
        stopAll();
        if (v instanceof LVCircular) {
            ((LVCircular) v).startAnim();
        } else if (v instanceof LVCircularCD) {
            ((LVCircularCD) v).startAnim();
        } else if (v instanceof LVCircularSmile) {
            ((LVCircularSmile) v).startAnim();
        } else if (v instanceof LVCircularRing) {
            ((LVCircularRing) v).startAnim();
        } else if (v instanceof LVCircularZoom) {
            ((LVCircularZoom) v).startAnim();
        } else if (v instanceof LVCircularJump) {
            ((LVCircularJump) v).startAnim();
        } else if (v instanceof LVEatBeans) {
            ((LVEatBeans) v).startAnim();
        } else if (v instanceof LVPlayBall) {
            ((LVPlayBall) v).startAnim();
        } else if (v instanceof LVLineWithText) {
            startLVLineWithTextAnim();
        } else if (v instanceof LVGears) {
            ((LVGears) v).startAnim();
        } else if (v instanceof LVGearsTwo) {
            ((LVGearsTwo) v).startAnim();
        } else if (v instanceof LVFinePoiStar) {
            ((LVFinePoiStar) v).setDrawPath(false);
            ((LVFinePoiStar) v).startAnim();
        } else if (v instanceof LVChromeLogo) {
            ((LVChromeLogo) v).startAnim();
        } else if (v instanceof LVBattery) {
            ((LVBattery) v).startAnim();
        } else if (v instanceof LVWifi) {
            ((LVWifi) v).startAnim();
        } else if (v instanceof LVNews) {
//            ((LVNews) v).startAnim();
            startLVNewsAnim();
        } else if (v instanceof LVBlock) {
            ((LVBlock) v).startAnim();

        } else if (v instanceof LVGhost) {
            ((LVGhost) v).startAnim();
        }


    }

    public void startAnimAll(View v) {
        mLVCircular.startAnim();
        mLVCircularRing.startAnim();
        mLVPlayBall.startAnim();
        mLVCircularJump.startAnim();
        mLVCircularZoom.startAnim();
        startLVLineWithTextAnim();
        mLVEatBeans.startAnim();
        mLVCircularCD.startAnim();
        mLVCircularSmile.startAnim();
        mLVGears.startAnim();
        mLVGearsTwo.startAnim();
        mLVFinePoiStar.setDrawPath(true);
        mLVFinePoiStar.startAnim();
        mLVChromeLogo.startAnim();
        mLVBattery.startAnim();
        mLVWifi.startAnim();
//        mLVNews.startAnim();
        startLVNewsAnim();
        mLVBlock.startAnim();
        mLVGhost.startAnim();
    }


    public void stopAnim(View v) {

        stopAll();

    }

    private void stopAll() {
        mLVCircular.stopAnim();
        mLVPlayBall.stopAnim();
        mLVCircularJump.stopAnim();
        mLVCircularZoom.stopAnim();
        mLVCircularRing.stopAnim();
        mLVEatBeans.stopAnim();
        stopLVLineWithTextAnim();
        mLVCircularCD.stopAnim();
        mLVCircularSmile.stopAnim();
        mLVGears.stopAnim();
        mLVGearsTwo.stopAnim();
        mLVFinePoiStar.stopAnim();
        mLVChromeLogo.stopAnim();
        mLVBattery.stopAnim();
        mLVWifi.stopAnim();
        stopLVNewsAnim();
        mLVBlock.stopAnim();
        mLVGhost.stopAnim();
    }


    public Timer mTimerLVLineWithText = new Timer();// 定时器
    public Timer mTimerLVNews = new Timer();// 定时器


    private void startLVLineWithTextAnim() {
        mValueLVLineWithText = 0;
        if (mTimerLVLineWithText != null) {
            mTimerLVLineWithText.cancel();// 退出之前的mTimer
        }
        mTimerLVLineWithText = new Timer();
        timerTaskLVLineWithText();
    }

    private void stopLVLineWithTextAnim() {
        if (mTimerLVLineWithText != null) {
            mTimerLVLineWithText.cancel();// 退出之前的mTimer
            mLVNews.setValue(mValueLVNews);
        }
    }


    private void startLVNewsAnim() {
        mValueLVNews = 0;
        if (mTimerLVNews != null) {

            mTimerLVNews.cancel();
        }
        mTimerLVNews = new Timer();
        timerTaskLVNews();
    }

    private void stopLVNewsAnim() {
        mLVNews.stopAnim();
        if (mTimerLVNews != null) {
            mTimerLVNews.cancel();
            mLVLineWithText.setValue(mValueLVLineWithText);
        }
    }


    public void timerTaskLVNews() {
        mTimerLVNews.schedule(new TimerTask() {
            @Override
            public void run() {
                if (mValueLVNews < 100) {
                    mValueLVNews++;
                    Message msg = mHandle.obtainMessage(1);
                    msg.arg1 = mValueLVNews;
                    mHandle.sendMessage(msg);
                } else {
                    mTimerLVNews.cancel();
                }
            }
        }, 0, 10);
    }


    public void timerTaskLVLineWithText() {
        mTimerLVLineWithText.schedule(new TimerTask() {
            @Override
            public void run() {
                if (mValueLVLineWithText < 100) {

                    mValueLVLineWithText++;
                    Message msg = mHandle.obtainMessage(2);
                    msg.arg1 = mValueLVLineWithText;
                    mHandle.sendMessage(msg);

                } else {
                    mTimerLVLineWithText.cancel();
                }
            }
        }, 0, 50);
    }


    private Handler mHandle = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 2)
                mLVLineWithText.setValue(msg.arg1);
            else if (msg.what == 1) {
                mLVNews.setValue(msg.arg1);
            }
        }
    };


}
