package com.dyx.acf.view.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyx.acf.R;
import com.dyx.rv.library.base.BaseViewHolder;
import com.dyx.rv.library.listener.OnItemClickListener;

import butterknife.Bind;

/**
 * project name：AndroidCodeFragment
 * class describe：
 * create person：dayongxin
 * create time：16/8/8 下午11:25
 * alter person：dayongxin
 * alter time：16/8/8 下午11:25
 * alter remark：
 */
public class MainViewHolder extends BaseViewHolder<String> {
    @Bind(R.id.tv_item)
    TextView tvItem;

    public MainViewHolder(Context context, ViewGroup parent) {
        super(context, parent, R.layout.item_main_layout);
    }

    @Override
    protected void bindData(final String itemValue, final int position, final OnItemClickListener<String> mOnItemClickListener) {
        if (itemValue != null) {
            tvItem.setText(itemValue);
        }

        tvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener == null) {
                    return;
                }
                mOnItemClickListener.onItemClick(itemValue, view.getId(), position);
            }
        });
    }
}
