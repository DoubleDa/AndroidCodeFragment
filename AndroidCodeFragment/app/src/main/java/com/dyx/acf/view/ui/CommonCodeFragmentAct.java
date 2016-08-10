package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.common.CommonUtils;
import com.dyx.utils.library.common.NetWorkUtils;
import com.orhanobut.logger.Logger;

import java.io.File;

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
    @Bind(R.id.btn_get_device_imei)
    Button btnGetDeviceImei;
    @Bind(R.id.btn_get_mac_address)
    Button btnGetMacAddress;
    @Bind(R.id.btn_get_app_version)
    Button btnGetAppVersion;
    @Bind(R.id.btn_collect_device_info_str)
    Button btnCollectDeviceInfoStr;
    @Bind(R.id.btn_have_sdcard)
    Button btnHaveSdcard;
    @Bind(R.id.et_hide_soft_input)
    EditText etHideSoftInput;
    @Bind(R.id.btn_hide_soft_input)
    Button btnHideSoftInput;
    @Bind(R.id.btn_show_soft_input)
    Button btnShowSoftInput;
    @Bind(R.id.btn_toggle_soft_input)
    Button btnToggleSoftInput;
    @Bind(R.id.btn_go_home)
    Button btnGoHome;
    @Bind(R.id.btn_get_statusbar_height)
    Button btnGetStatusbarHeight;
    @Bind(R.id.btn_get_top_bar_height)
    Button btnGetTopBarHeight;
    @Bind(R.id.btn_get_network_operator)
    Button btnGetNetworkOperator;
    @Bind(R.id.btn_get_network_operator_name)
    Button btnGetNetworkOperatorName;
    @Bind(R.id.btn_get_phone_type)
    Button btnGetPhoneType;
    @Bind(R.id.btn_get_network_class)
    Button btnGetNetworkClass;
    @Bind(R.id.btn_get_network_status)
    Button btnGetNetworkStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_common_code_fragment_layout);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_call, R.id.btn_call_dial, R.id.btn_send_sms, R.id.btn_wake_up_and_unlock, R.id.btn_is_application_background,
            R.id.btn_is_sleeping, R.id.btn_is_online, R.id.btn_is_wifi_connected, R.id.btn_install_apk, R.id.btn_is_phone, R.id.btn_get_device,
            R.id.btn_get_device_imei, R.id.btn_get_mac_address, R.id.btn_get_app_version, R.id.btn_collect_device_info_str, R.id.btn_have_sdcard,
            R.id.btn_hide_soft_input, R.id.btn_show_soft_input, R.id.btn_go_home, R.id.btn_get_statusbar_height, R.id.btn_get_top_bar_height,
            R.id.btn_get_network_operator, R.id.btn_get_network_operator_name, R.id.btn_get_phone_type, R.id.btn_get_network_class,
            R.id.btn_get_network_status})
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
                Logger.d(CommonUtils.isApplicationBackground(this));
                break;
            case R.id.btn_is_sleeping:
                Logger.d(CommonUtils.isSleeping(this));
                break;
            case R.id.btn_is_online:
                Logger.d(CommonUtils.isOnline(this));
                break;
            case R.id.btn_is_wifi_connected:
                Logger.d(CommonUtils.isWifiConnected(this));
                break;
            case R.id.btn_install_apk:
                /**
                 * TODO 安装Apk
                 * 研究静默安装
                 */
                CommonUtils.installApk(this, new File(""));
                break;
            case R.id.btn_is_phone:
                Logger.d(CommonUtils.isPhone(this));
                break;
            case R.id.btn_get_device:
                Logger.d("Width:" + CommonUtils.getDeviceWidth(this) + "|Height:" + CommonUtils.getDeviceHeight(this));
                break;
            case R.id.btn_get_device_imei:
                /**
                 * TODO 6.0权限
                 */
                Logger.d(CommonUtils.getDeviceIMEI(this));
                break;
            case R.id.btn_get_mac_address:
                Logger.d(CommonUtils.getMacAddress(this));
                break;
            case R.id.btn_get_app_version:
                Logger.d(CommonUtils.getAppVersion(this));
                break;
            case R.id.btn_collect_device_info_str:
                Logger.d(CommonUtils.collectDeviceInfoStr(this));
                break;
            case R.id.btn_have_sdcard:
                Logger.d(CommonUtils.haveSDCard());
                break;
            case R.id.btn_hide_soft_input:
                CommonUtils.hideSoftInput(this, etHideSoftInput);
                break;
            case R.id.btn_show_soft_input:
                CommonUtils.showSoftInput(this, etHideSoftInput);
                break;
            case R.id.btn_toggle_soft_input:
                CommonUtils.toggleSoftInput(this, etHideSoftInput);
                break;
            case R.id.btn_go_home:
                CommonUtils.goHome(this);
                break;
            case R.id.btn_get_statusbar_height:
                Logger.d(CommonUtils.getStatusBarHeight(this));
                break;
            case R.id.btn_get_top_bar_height:
                Logger.d(CommonUtils.getTopBarHeight(this));
                break;
            case R.id.btn_get_network_operator:
                Logger.d(CommonUtils.getNetworkOperator(this));
                break;
            case R.id.btn_get_network_operator_name:
                Logger.d(CommonUtils.getNetworkOperatorName(this));
                break;
            case R.id.btn_get_phone_type:
                /**
                 * PHONE_TYPE_NONE :0 手机制式未知
                 PHONE_TYPE_GSM :1 手机制式为GSM，移动和联通
                 PHONE_TYPE_CDMA :2 手机制式为CDMA，电信
                 PHONE_TYPE_SIP:3
                 */
                Logger.d(CommonUtils.getPhoneType(this));
                break;
            case R.id.btn_get_network_class:
                Logger.d(NetWorkUtils.getNetWorkClass(this));
                break;
            case R.id.btn_get_network_status:
                Logger.d(NetWorkUtils.getNetWorkStatus(this));
                break;
            default:
                break;
        }
    }
}
