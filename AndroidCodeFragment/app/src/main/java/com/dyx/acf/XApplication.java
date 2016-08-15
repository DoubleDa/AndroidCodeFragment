package com.dyx.acf;

import android.app.Application;
import android.content.Context;

/**
 * project name：AndroidCodeFragment
 * class describe：
 * create person：dayongxin
 * create time：16/8/8 下午11:24
 * alter person：dayongxin
 * alter time：16/8/8 下午11:24
 * alter remark：
 */
public class XApplication extends Application {
    private static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getInstance() {
        return instance;
    }
}
