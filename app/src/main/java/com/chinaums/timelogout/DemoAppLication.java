package com.chinaums.timelogout;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;

/**
 * 弃用，改成eventBus
 */
public class DemoAppLication extends Application {

    private static DemoAppLication instance;
    /**
     * 存放activity集合 占用内存比较大，同时List里面的元素回收比较困难会导致内存泄漏
     */
    private ArrayList<Activity> list;

    @Override
    public void onCreate() {
        super.onCreate();
        list = new ArrayList<>();
    }

    public static DemoAppLication getInstance() {
        if(null == instance) {
            instance = new DemoAppLication();
        }
        return instance;
    }


    public void addActivity(Activity activity) {
        if (list ==  null)
            list = new ArrayList<>();
        list.add(activity);
    }

    public void exit() {
        try {
            for (Activity activity : list) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
