package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.widget.Button;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.timer.MyCountTimer;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dayongxin on 2016/8/16.
 */
public class MyTimerCountAct extends BaseActivity {
    @Bind(R.id.btn_start_timer)
    Button btnStartTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_my_timer_count_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_start_timer)
    public void onClick() {
        MyCountTimer timer = new MyCountTimer(btnStartTimer, 0xfff30008, 0xff969696);
        timer.start();
    }
}
