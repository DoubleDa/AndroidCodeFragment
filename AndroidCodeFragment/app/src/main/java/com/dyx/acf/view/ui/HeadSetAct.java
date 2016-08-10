package com.dyx.acf.view.ui;

import android.content.IntentFilter;
import android.os.Bundle;

import com.dyx.acf.R;
import com.dyx.acf.receiver.HeadSetStateReceiver;
import com.dyx.acf.view.base.BaseActivity;

/**
 * Created by dayongxin on 2016/8/10.
 * http://www.open-open.com/code/view/1420949343968
 */
public class HeadSetAct extends BaseActivity {
    private HeadSetStateReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_head_set_layout);
        registerMyReceiver();
    }

    private void registerMyReceiver() {
        receiver = new HeadSetStateReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.HEADSET_PLUG");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
    }
}
