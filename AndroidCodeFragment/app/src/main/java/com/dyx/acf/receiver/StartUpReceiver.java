package com.dyx.acf.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.dyx.acf.view.ui.StartUpAct;

/**
 * Created by dayongxin on 2016/8/16.
 */
public class StartUpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startupintent = new Intent(context, StartUpAct.class);
        startupintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startupintent);
    }
}
