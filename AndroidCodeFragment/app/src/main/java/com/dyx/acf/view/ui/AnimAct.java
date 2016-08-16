package com.dyx.acf.view.ui;

import android.os.Bundle;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.screen.TsunamiUtils;

import butterknife.ButterKnife;

/**
 * Created by dayongxin on 2016/8/16.
 */
public class AnimAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_anim_layout);
        ButterKnife.bind(this);
        TsunamiUtils.FullScreenTsunami(this);
    }
}
