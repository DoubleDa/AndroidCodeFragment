package com.dyx.utils.library.common;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;

/**
 * Created by dayongxin on 2016/8/10.
 */
public class VibratorUtil {
    /**
     * long milliseconds ：震动的时长，单位是毫秒
     * long[] pattern  ：自定义震动模式 。数组中数字的含义依次是[静止时长，震动时长，静止时长，震动时长。。。]时长的单位是毫秒
     * boolean isRepeat ： 是否反复震动，如果是true，反复震动，如果是false，只震动一次
     */
    public static void Vibrate(final Context context) {
        long milliseconds = 100;
        Vibrator vib = (Vibrator) context.getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(milliseconds);
    }

    public static void Vibrate(final Context context, long milliseconds) {
        Vibrator vib = (Vibrator) context.getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(milliseconds);
    }

    public static void Vibrate(final Context context, long[] pattern, boolean isRepeat) {
        Vibrator vib = (Vibrator) context.getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(pattern, isRepeat ? 1 : -1);//-1为反复震动
    }

}
