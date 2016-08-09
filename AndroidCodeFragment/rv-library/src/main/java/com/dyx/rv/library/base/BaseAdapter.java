package com.dyx.rv.library.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.dyx.rv.library.listener.OnItemClickListener;

import java.util.List;

/**
 * project name：AndroidCodeFragment
 * class describe：http://blog.csdn.net/luoyanglizi/article/details/51519686
 * create person：dayongxin
 * create time：16/8/8 下午11:14
 * alter person：dayongxin
 * alter time：16/8/8 下午11:14
 * alter remark：
 */
public abstract class BaseAdapter<V> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    //数据集
    private List<V> mDataList;
    //条目点击事件
    private OnItemClickListener<V> mOnItemClickListener;

    /**
     * Set方法
     *
     * @param mOnItemClickListener
     */
    public void setmOnItemClickListener(OnItemClickListener<V> mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    /**
     * onCreateViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createViewHolder(parent.getContext(), parent);
    }

    /**
     * onBindViewHolder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseViewHolder) holder).setData(mDataList.get(position), position, mOnItemClickListener);
    }

    /**
     * getItemCount
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    /**
     * refreshData
     *
     * @param valueList
     */
    public void refreshData(List<V> valueList) {
        this.mDataList = valueList;
        notifyDataSetChanged();
    }

    protected abstract BaseViewHolder createViewHolder(Context context, ViewGroup parent);

}
