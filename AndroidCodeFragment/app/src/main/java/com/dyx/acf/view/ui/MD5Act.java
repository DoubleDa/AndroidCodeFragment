package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.common.MD5Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dayongxin on 2016/8/10.
 */
public class MD5Act extends BaseActivity {
    @Bind(R.id.et_input)
    EditText etInput;
    @Bind(R.id.btn_get_result)
    Button btnGetResult;
    @Bind(R.id.tv_show)
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_md5_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_get_result)
    public void onClick() {
        String result = etInput.getText().toString().trim();
        if (!result.equals("")) {
            tvShow.setText(MD5Utils.md5Password(result));
        }
    }
}
