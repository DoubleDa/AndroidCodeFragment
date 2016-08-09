package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.common.CommonUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * project name：AndroidCodeFragment
 * class describe：
 * create person：dayongxin
 * create time：16/8/8 下午11:42
 * alter person：dayongxin
 * alter time：16/8/8 下午11:42
 * alter remark：
 */
public class CommonCodeFragmentAct extends BaseActivity {
    @Bind(R.id.btn_call)
    Button btnCall;
    @Bind(R.id.btn_call_dial)
    Button btnCallDial;
    @Bind(R.id.btn_send_sms)
    Button btnSendSms;
    @Bind(R.id.btn_wake_up_and_unlock)
    Button btnWakeUpAndUnlock;
    @Bind(R.id.btn_is_application_background)
    Button btnIsApplicationBackground;
    @Bind(R.id.btn_is_sleeping)
    Button btnIsSleeping;
    @Bind(R.id.btn_is_online)
    Button btnIsOnline;
    @Bind(R.id.btn_is_wifi_connected)
    Button btnIsWifiConnected;
    @Bind(R.id.btn_install_apk)
    Button btnInstallApk;
    @Bind(R.id.btn_is_phone)
    Button btnIsPhone;
    @Bind(R.id.btn_get_device)
    Button btnGetDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_common_code_fragment_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_call, R.id.btn_call_dial, R.id.btn_send_sms, R.id.btn_wake_up_and_unlock, R.id.btn_is_application_background, R.id.btn_is_sleeping, R.id.btn_is_online, R.id.btn_is_wifi_connected, R.id.btn_install_apk, R.id.btn_is_phone, R.id.btn_get_device})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_call:
                CommonUtils.call(this, "18716321583");
                break;
            case R.id.btn_call_dial:
                CommonUtils.callDial(this, "18716321583");
                break;
            case R.id.btn_send_sms:
                CommonUtils.sendSms(this, "18716321583", "Send Message!");
                break;
            case R.id.btn_wake_up_and_unlock:
                CommonUtils.wakeUpAndUnlock(this);
                break;
            case R.id.btn_is_application_background:
                break;
            case R.id.btn_is_sleeping:
                break;
            case R.id.btn_is_online:
                break;
            case R.id.btn_is_wifi_connected:
                break;
            case R.id.btn_install_apk:
                break;
            case R.id.btn_is_phone:
                break;
            case R.id.btn_get_device:
                break;
        }
    }
}
