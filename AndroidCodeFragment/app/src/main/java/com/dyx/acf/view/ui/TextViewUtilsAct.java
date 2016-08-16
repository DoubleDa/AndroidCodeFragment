package com.dyx.acf.view.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.textview.TextViewUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dayongxin on 2016/8/16.
 */
public class TextViewUtilsAct extends BaseActivity {
    @Bind(R.id.tv_set_size)
    TextView tvSetSize;
    @Bind(R.id.tv_set_color)
    TextView tvSetColor;
    @Bind(R.id.tv_set_underline)
    TextView tvSetUnderline;
    @Bind(R.id.tv_cancel_underline)
    TextView tvCancelUnderline;
    @Bind(R.id.tv_to_dbc)
    TextView tvToDbc;
    @Bind(R.id.tv_replace_char)
    TextView tvReplaceChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_text_view_util_layout);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        /**
         * 设置部分大小
         */
        TextViewUtil.setPartialSize(tvSetSize, 12, 20, 18);
        /**
         * 设置部分颜色
         */
        TextViewUtil.setPartialColor(tvSetColor, 10, 24, Color.parseColor("#FF7F50"));
        /**
         * TextView设置下划线
         */
        TextViewUtil.setUnderLine(tvSetUnderline);
        /**
         * 取消TextView的置下划线
         */
        TextViewUtil.clearUnderLine(tvCancelUnderline);
        /**
         * 半角转换为全角
         */
    }
}
