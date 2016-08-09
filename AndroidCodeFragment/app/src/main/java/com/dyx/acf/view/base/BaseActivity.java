package com.dyx.acf.view.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * project name：AndroidCodeFragment
 * class describe：
 * create person：dayongxin
 * create time：16/8/8 下午11:40
 * alter person：dayongxin
 * alter time：16/8/8 下午11:40
 * alter remark：
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void intentTo(Class<?> cla) {
        startActivity(new Intent(this, cla));
    }
}
