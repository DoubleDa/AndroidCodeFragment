package com.dyx.acf.view.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.common.ClearDataUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dayongxin on 2016/8/11.
 */
public class ClearDataAct extends BaseActivity {
    @Bind(R.id.btn_clear_data)
    Button btnClearData;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_clear_data_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_clear_data)
    public void onClick() {
        dialog = new ProgressDialog(this);
        dialog.setTitle(getString(R.string.clear_dataing));
        dialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ClearDataUtils.cleanApplicationData(ClearDataAct.this);
                    Thread.sleep(3000);
                    dialog.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
