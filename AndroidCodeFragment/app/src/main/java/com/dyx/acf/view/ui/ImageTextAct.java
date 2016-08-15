package com.dyx.acf.view.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dayongxin on 2016/8/15.
 */
public class ImageTextAct extends BaseActivity {
    @Bind(R.id.iv_image_text)
    ImageView ivImageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_image_text_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        BitmapDrawable bd = (BitmapDrawable) drawable;
        Bitmap bmp = bd.getBitmap();
        Bitmap bitmap = createWatermark(bmp, "@哒哒");
        ivImageText.setImageBitmap(bitmap);
    }

    private Bitmap createWatermark(Bitmap target, String s) {
        int w = target.getWidth();
        int h = target.getHeight();
        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint p = new Paint();
        // 水印的颜色
        p.setColor(Color.RED);
        // 水印的字体大小
        p.setTextSize(10);
        // 去锯齿
        p.setAntiAlias(true);
        canvas.drawBitmap(target, 0, 0, p);
        // 在左边的中间位置开始添加水印
        canvas.drawText(s, 0, h / 2, p);
        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore();
        return bmp;
    }
}
