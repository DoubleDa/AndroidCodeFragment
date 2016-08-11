package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.common.ApkInstallUtils;
import com.orhanobut.logger.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dayongxin on 2016/8/11.
 */
public class InstallApkBackgroundAct extends BaseActivity {
    @Bind(R.id.btn_install)
    Button btnInstall;
    @Bind(R.id.btn_uninstall)
    Button btnUninstall;
    @Bind(R.id.btn_start_app)
    Button btnStartApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_install_apk_background_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_install, R.id.btn_uninstall, R.id.btn_start_app})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_install:
                installApk();
                break;
            case R.id.btn_uninstall:
                unInstallApk();
                break;
            case R.id.btn_start_app:
                startApp();
                break;
        }
    }

    private void startApp() {
        if (ApkInstallUtils.startApp("com.dyx.install", "com.dyx.install.MainActivity")) {
            showSnackbar(btnStartApp, getString(R.string.start_apk_success));
        } else {
            showSnackbar(btnStartApp, getString(R.string.start_apk_failed));
        }
    }

    private void unInstallApk() {
        new Thread() {
            @Override
            public void run() {
                if (ApkInstallUtils.uninstall("com.dyx.install", InstallApkBackgroundAct.this)) {
                    showSnackbar(btnUninstall, getString(R.string.uninstall_success));
                } else {
                    showSnackbar(btnUninstall, getString(R.string.uninstall_failed));
                }
            }
        }.start();
    }

    private void installApk() {
        new Thread() {
            @Override
            public void run() {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/installApk.apk";
                if (ApkInstallUtils.install(path, InstallApkBackgroundAct.this)) {
                    showSnackbar(btnInstall, getString(R.string.install_success));
                } else {
                    showSnackbar(btnInstall, getString(R.string.install_failed));
                }
            }
        }.start();
    }
}
