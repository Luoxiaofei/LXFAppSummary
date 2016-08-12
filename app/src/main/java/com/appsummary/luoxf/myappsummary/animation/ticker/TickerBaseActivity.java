package com.appsummary.luoxf.myappsummary.animation.ticker;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.appsummary.luoxf.myappsummary.BaseActivity;

import java.util.Random;

public abstract class TickerBaseActivity extends BaseActivity {
    protected static final Random RANDOM = new Random(System.currentTimeMillis());

    private Handler handler = new Handler();
    private boolean resumed;

    @Override
    protected void onResume() {
        super.onResume();
        resumed = true;
        handler.post(createRunnable());
    }

    private Runnable createRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                onUpdate();
                if (resumed) {
                    handler.postDelayed(createRunnable(), RANDOM.nextInt(1750) + 250);
                }
            }
        };
    }

    protected abstract void onUpdate();

    @Override
    protected void onPause() {
        resumed = false;
        super.onPause();
    }

    protected String getRandomNumber(int digits) {
        final int digitsInPowerOf10 = (int) Math.pow(10, digits);
        return Integer.toString(RANDOM.nextInt(digitsInPowerOf10) +
                digitsInPowerOf10 * (RANDOM.nextInt(8) + 1));
    }
}
