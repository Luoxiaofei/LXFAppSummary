package com.appsummary.luoxf.myappsummary.more.smsobserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.appsummary.luoxf.myappsummary.R;
import com.robin.lazy.sms.SmsObserver;
import com.robin.lazy.sms.SmsResponseCallback;
import com.robin.lazy.sms.VerificationCodeSmsFilter;

public class SmsObserverActivity extends AppCompatActivity implements SmsResponseCallback {

    private TextView textView;
    private SmsObserver smsObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_observer);
        smsObserver=new SmsObserver(this,this,new VerificationCodeSmsFilter("180"));
        smsObserver.registerSMSObserver();
        textView=(TextView)findViewById(R.id.textView);
        //6.0以上手机
//        Dexter.checkPermission(new CompositePermissionListener(), Manifest.permission.READ_SMS);
    }

    @Override
    public void onCallbackSmsContent(String code) {
        textView.setText("短信验证码:"+code);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        smsObserver.unregisterSMSObserver();
    }
}
