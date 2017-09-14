package com.chinaums.timelogout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DemoAppLication.getInstance().addActivity(this);
    }

    public void skipA(View view) {

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, AActivity.class);
        startActivity(intent);
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        if (event.getCode() == 1000){
            Log.e("TAG","MainActivity");
            MainActivity.this.finish();
        }
    }

}
