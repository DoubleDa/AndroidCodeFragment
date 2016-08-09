package com.dyx.acf.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.dyx.acf.view.viewholder.MainViewHolder;
import com.dyx.rv.library.base.BaseAdapter;
import com.dyx.rv.library.base.BaseViewHolder;

/**
 * project name：AndroidCodeFragment
 * class describe：
 * create person：dayongxin
 * create time：16/8/8 下午11:25
 * alter person：dayongxin
 * alter time：16/8/8 下午11:25
 * alter remark：
 */
public class MainAdapter extends BaseAdapter<String> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new MainViewHolder(context, parent);
    }
}
