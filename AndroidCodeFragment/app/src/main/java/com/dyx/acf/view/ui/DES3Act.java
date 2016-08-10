package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.common.DES3Utils;
import com.orhanobut.logger.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dayongxin on 2016/8/10.
 */
public class DES3Act extends BaseActivity {
    private static final String ENCRYPT_MSG = "中华人民共和国保守国家秘密法";
    @Bind(R.id.btn_nothing)
    Button btnNothing;
    @Bind(R.id.btn_encrypt)
    Button btnEncrypt;
    @Bind(R.id.btn_decode)
    Button btnDecode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_des3_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_nothing, R.id.btn_encrypt, R.id.btn_decode})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_nothing:
                Logger.d(ENCRYPT_MSG);
                break;
            case R.id.btn_encrypt:
                Logger.d(new String(DES3Utils.encryptMode(ENCRYPT_MSG.getBytes())));
                break;
            case R.id.btn_decode:
                Logger.d(new String(DES3Utils.decryptMode(DES3Utils.encryptMode(ENCRYPT_MSG.getBytes()))));
                break;
        }
    }
}
