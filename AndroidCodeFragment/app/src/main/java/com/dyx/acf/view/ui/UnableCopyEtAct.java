package com.dyx.acf.view.ui;

import android.os.Bundle;

import com.dyx.acf.R;
import com.dyx.acf.customlibrary.widget.UnableCopyEditText;
import com.dyx.acf.view.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dayongxin on 2016/8/15.
 */
public class UnableCopyEtAct extends BaseActivity {
    @Bind(R.id.et_unable_copy)
    UnableCopyEditText etUnableCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_unable_copy_et_layout);
        ButterKnife.bind(this);
    }
}
