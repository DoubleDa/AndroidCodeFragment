package com.dyx.acf.customlibrary.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Map;

/**
 * Created by dayongxin on 2016/8/15.
 */
public class AdViewPagerAdapter extends PagerAdapter {
    private Context context;
    private List<Map<String, String>> urls;

    public AdViewPagerAdapter(Context context, List<Map<String, String>> urls) {
        this.context = context;
        this.urls = urls;
    }

    @Override
    public int getCount() {
        if (urls != null && urls.size() > 0) {
            return urls.size();
        } else {
            return 0;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
