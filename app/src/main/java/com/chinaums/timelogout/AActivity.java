package com.chinaums.timelogout;

import android.os.Bundle;
import android.util.Log;

import org.greenrobot.eventbus.Subscribe;

public class AActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
//        DemoAppLication.getInstance().addActivity(this);
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        if (event.getCode() == 1000){
            Log.e("TAG","AActivity");
            AActivity.this.finish();
        }
    }

}
