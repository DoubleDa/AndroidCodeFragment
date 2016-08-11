package com.dyx.acf.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by dayongxin on 2016/8/11.
 */
public class MsgReceiver extends BroadcastReceiver {
    String receiveMsg = "";

    public void onReceive(Context context, Intent intent) {
        SmsMessage[] msg = null;

        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            //StringBuilder buf = new StringBuilder();
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdusObj = (Object[]) bundle.get("pdus");
                msg = new SmsMessage[pdusObj.length];
                for (int i = 0; i < pdusObj.length; i++)
                    msg[i] = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
            }


            for (int i = 0; i < msg.length; i++) {
                String msgTxt = msg[i].getMessageBody();
                if (msgTxt.equals("Testing!")) {
                    Toast.makeText(context, "success!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Toast.makeText(context, msgTxt, Toast.LENGTH_LONG).show();
                    return;
                }
            }
            return;
        }

    }
}
