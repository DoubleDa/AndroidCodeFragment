package com.dyx.acf.view.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.common.ScreenShotUtils;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dayongxin on 2016/8/10.
 */
public class ScreenShotAct extends BaseActivity {
    @Bind(R.id.btn_screen_shot)
    Button btnScreenShot;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_screen_shot_layout);
        ButterKnife.bind(this);
        activity = this;
    }

    @OnClick(R.id.btn_screen_shot)
    public void onClick() {
        String savePath = Environment.getExternalStorageDirectory() + "/dyx/myImages";
        try {
            File filePath = new File(savePath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            String filepath = savePath + "/today.png";
            File file = new File(filepath);
            if (!file.exists()) {
                file.createNewFile();
            }
            new ScreenShotUtils(activity).saveScreenshopBitmap(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
