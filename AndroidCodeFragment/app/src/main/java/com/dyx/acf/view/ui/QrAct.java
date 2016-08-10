package com.dyx.acf.view.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.common.QRUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dayongxin on 2016/8/10.
 */
public class QrAct extends BaseActivity {
    @Bind(R.id.iv_show)
    ImageView ivShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_qr_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        int w = outMetrics.widthPixels * 8 / 11;//设置宽度
        ViewGroup.LayoutParams layoutParams = ivShow.getLayoutParams();
        layoutParams.height = layoutParams.width = w;//设置高度
        ivShow.setLayoutParams(layoutParams);

        try {
            //要生成二维码的内容，我这就是一个网址
            Bitmap bitmap = QRUtils.encodeToQRWidth("http://www.dayongxin.com/", w);
            ivShow.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
            showSnackbar(ivShow, getString(R.string.qr_error));
        }
    }
}
