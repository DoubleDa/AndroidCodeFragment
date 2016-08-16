package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dayongxin on 2016/8/16.
 */
public class TimerUpdateAct extends BaseActivity {
    @Bind(R.id.tv_show_update)
    TextView tvShowUpdate;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            int result = bundle.getInt("data");
            tvShowUpdate.setText("执行次数为：" + result);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_timer_update_layout);
        ButterKnife.bind(this);
        Timer mTimer = new Timer(true);
        mTimer.scheduleAtFixedRate(new MyTask(), 1000, 2000);
    }

    private class MyTask extends TimerTask {
        @Override
        public void run() {
            int i = 0;
            i++;
            Bundle bundle = new Bundle();
            bundle.putInt("data", i);
            Message message = new Message();
            message.setData(bundle);
            handler.sendMessage(message);
        }
    }
}
