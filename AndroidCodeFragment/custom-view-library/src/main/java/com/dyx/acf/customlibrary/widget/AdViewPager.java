package com.dyx.acf.customlibrary.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dayongxin on 2016/8/15.
 */
public class AdViewPager extends ViewPager {
    AdViewPagerAdapter mAdAdapter;
    Context context;
    Paint paint;
    List<Map<String, String>> urls;

    public AdViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        paint = new Paint();
        InitAdapter();
    }

    private void InitAdapter() {
        urls = new ArrayList<Map<String, String>>();
        mAdAdapter = new AdViewPagerAdapter(context, urls);
        this.setAdapter(mAdAdapter);
    }

    public void setData(List<Map<String, String>> data) {
        urls.clear();
        for (int i = 0; i < data.size(); i++) {
            urls.add(data.get(i));
        }
        if (urls.size() > 0) {
            this.setVisibility(View.VISIBLE);
        } else {
            this.setVisibility(View.GONE);
        }
        mAdAdapter.notifyDataSetChanged();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawCycle(canvas);
    }

    private void drawCycle(Canvas canvas) {
        canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        int count = 0;
        if (this.getAdapter() != null) {
            count = this.getAdapter().getCount();
        }
        int select = getCurrentItem();
        float density = getContext().getResources().getDisplayMetrics().density;
        int itemWidth = (int) (11 * density);
        int itemHeight = itemWidth / 2;
        int x = (getWidth() - count * itemWidth) / 2;
        int y = getHeight() - itemWidth;
        int minItemHeight = (int) ((float) itemHeight * 0.8F);
        paint.setAntiAlias(true);

        paint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < count; i++) {
            if (select == i) {
                paint.setColor(0xFFbdbdbd);
                canvas.drawCircle(x + itemWidth * i + itemWidth / 2, y, minItemHeight, paint);
            } else {
                paint.setColor(0xFFe6e6e6);
                canvas.drawCircle(x + itemWidth * i + itemWidth / 2, y, minItemHeight, paint);
            }
        }
        canvas.restore();
    }
}
