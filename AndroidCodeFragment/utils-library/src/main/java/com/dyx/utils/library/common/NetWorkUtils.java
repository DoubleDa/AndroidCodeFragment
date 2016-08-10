package com.dyx.utils.library.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * Created by dayongxin on 2016/8/10.
 */
public class NetWorkUtils {

    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_WIFI = 1;
    public static final int NETWORK_CLASS_2_G = 2;
    public static final int NETWORK_CLASS_3_G = 3;
    public static final int NETWORK_CLASS_4_G = 4;

    /**
     * 判断手机连接的网络类型(2G,3G,4G)
     *
     * @param context
     * @return
     */
    public static int getNetWorkClass(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        switch (telephonyManager.getNetworkType()) {

            case TelephonyManager.NETWORK_TYPE_GPRS:

            case TelephonyManager.NETWORK_TYPE_EDGE:

            case TelephonyManager.NETWORK_TYPE_CDMA:

            case TelephonyManager.NETWORK_TYPE_1xRTT:

            case TelephonyManager.NETWORK_TYPE_IDEN:

                return NETWORK_CLASS_2_G;

            case TelephonyManager.NETWORK_TYPE_UMTS:

            case TelephonyManager.NETWORK_TYPE_EVDO_0:

            case TelephonyManager.NETWORK_TYPE_EVDO_A:

            case TelephonyManager.NETWORK_TYPE_HSDPA:

            case TelephonyManager.NETWORK_TYPE_HSUPA:

            case TelephonyManager.NETWORK_TYPE_HSPA:

            case TelephonyManager.NETWORK_TYPE_EVDO_B:

            case TelephonyManager.NETWORK_TYPE_EHRPD:

            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return NETWORK_CLASS_3_G;
            case TelephonyManager.NETWORK_TYPE_LTE:
                return NETWORK_CLASS_4_G;
            default:
                return NETWORK_CLASS_UNKNOWN;
        }
    }

    /**
     * 判断当前手机的网络类型(WIFI还是2,3,4G)
     *
     * @param context
     * @return
     */
    public static int getNetWorkStatus(Context context) {
        int netWorkType = NETWORK_CLASS_UNKNOWN;
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            if (type == ConnectivityManager.TYPE_WIFI) {
                netWorkType = NETWORK_WIFI;
            } else if (type == ConnectivityManager.TYPE_MOBILE) {
                netWorkType = getNetWorkClass(context);
            }
        }
        return netWorkType;
    }
}
