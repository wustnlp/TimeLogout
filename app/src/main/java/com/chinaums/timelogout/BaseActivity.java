package com.chinaums.timelogout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import org.greenrobot.eventbus.EventBus;


public class BaseActivity extends AppCompatActivity {


    private Handler handler = new Handler();
    private long time = 1000 * 20;//20秒不操作，自动退出登录
    private boolean isShowDialog = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startAD();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                handler.removeCallbacks(runnable);
                break;
            case MotionEvent.ACTION_UP:
                startAD();
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            if (isShowDialog) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);
                builder.setTitle("温馨提示")
                        .setCancelable(false)
                        .setMessage("当前登录已失效，请重新登录")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.setClass(BaseActivity.this, LoginActivity.class);
                                startActivity(intent);
//                                DemoAppLication.getInstance().exit();
                                EventBus.getDefault().post(new MessageEvent(1000));
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }
    };

    public void startAD() {
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, time);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**注销只能在这里做*/
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isShowDialog = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isShowDialog = false;
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

}
