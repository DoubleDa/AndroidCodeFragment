package com.dyx.rv.library.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dyx.rv.library.listener.OnItemClickListener;

import butterknife.ButterKnife;

/**
 * project name：AndroidCodeFragment
 * class describe：
 * create person：dayongxin
 * create time：16/8/8 下午11:17
 * alter person：dayongxin
 * alter time：16/8/8 下午11:17
 * alter remark：
 */
public abstract class BaseViewHolder<V> extends RecyclerView.ViewHolder {
    public BaseViewHolder(Context context, ViewGroup parent, int layoutRes) {
        super(LayoutInflater.from(context).inflate(layoutRes, parent, false));
        ButterKnife.bind(this, itemView);
    }

    public Context getContext() {
        return itemView.getContext();
    }

    public void setData(V itemValue, int position, OnItemClickListener<V> mOnItemClickListener) {
        bindData(itemValue, position, mOnItemClickListener);
    }

    protected abstract void bindData(V itemValue, int position, OnItemClickListener<V> mOnItemClickListener);

}
