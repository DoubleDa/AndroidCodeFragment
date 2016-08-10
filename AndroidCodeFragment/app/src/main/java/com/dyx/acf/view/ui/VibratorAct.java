package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.widget.Button;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.common.VibratorUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dayongxin on 2016/8/10.
 */
public class VibratorAct extends BaseActivity {
    @Bind(R.id.btn_vibrator)
    Button btnVibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_vibrator_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_vibrator)
    public void onClick() {
        VibratorUtil.Vibrate(this);
    }
}
