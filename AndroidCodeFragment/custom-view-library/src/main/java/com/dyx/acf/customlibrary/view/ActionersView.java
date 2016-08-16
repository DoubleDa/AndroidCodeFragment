package com.dyx.acf.customlibrary.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.dyx.acf.customlibrary.R;

/**
 * Created by dayongxin on 2016/8/16.
 */
public class ActionersView extends View {

    private Paint mPaint = new Paint();
    private Paint txtPaint = new Paint();//文字画笔
    private Path mPath = new Path();//手指滑动路径
    private Canvas mCanvas;//缓存画布
    private Bitmap mBitmap;//缓存图片
    private float pointX, pointY;//触点坐标
    private String txtStr = "￥5,000,000";

    public ActionersView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888); // 初始化bitmap
        mCanvas = new Canvas(mBitmap);

        initPaint();//初始化画笔
//        mCanvas.drawRoundRect(new RectF(100, 500, width - 100, height - 500), 30, 30, mPaint);//效果一：背景为灰色的矩形
        mCanvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher), null, new RectF(100, 500, width - 100, height - 500), null);//效果二：背景为图片

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        txtPaint.setTextSize(60);
        canvas.drawText(txtStr, getWidth() / 2 - 150, getHeight() / 2, txtPaint);

        mCanvas.drawPath(mPath, mPaint);
        canvas.drawBitmap(mBitmap, 0, 0, null);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        pointX = event.getX();
        pointY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(pointX, pointY);//将路径移动到点(pointX, pointY)，不绘制
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(pointX, pointY);//绘制一条从上个触点到点(pointX, pointY)的线条
                break;
        }
        invalidate();//重新绘图
        return true;
    }


    private void initPaint() {//初始化画笔
        mPaint.setDither(true);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(30);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setColor(Color.parseColor("#c0c0c0"));
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
}
