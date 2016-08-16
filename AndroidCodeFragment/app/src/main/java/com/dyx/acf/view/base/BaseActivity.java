package com.dyx.acf.view.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.dyx.utils.library.app.AppManager;

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
        AppManager.getAppManager().addActivity(this);
    }

    public void intentTo(Class<?> cla) {
        startActivity(new Intent(this, cla));
    }

    public void showSnackbar(View view, String msg) {
        if (msg == null) {
            return;
        }
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }
}
