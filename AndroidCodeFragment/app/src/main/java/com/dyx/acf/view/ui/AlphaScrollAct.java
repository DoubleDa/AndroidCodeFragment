package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.widget.ScrollView;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dayongxin on 2016/8/15.
 */
public class AlphaScrollAct extends BaseActivity {
    @Bind(R.id.scroll_view)
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_alpha_scroll_layout);
        ButterKnife.bind(this);
        //TODO ScrollView滚动动态设置Topbar的背景透明度
    }
}
