package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dyx.acf.R;
import com.dyx.acf.view.adapter.MainAdapter;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.rv.library.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dayongxin on 2016/8/15.
 */
public class ScrollUpAct extends BaseActivity {
    @Bind(R.id.rv_load_more)
    RecyclerView rvLoadMore;
    //加载更多界面
    private View loadMoreView;
    private MainAdapter adapter;
    private List<String> listData;
    private int lastItem, itemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_scroll_up_layout);
        ButterKnife.bind(this);

        loadMoreView = getLayoutInflater().inflate(R.layout.view_load_more, null);
        listData = new ArrayList<>();

        initData();
        itemCount = listData.size();
        adapter = new MainAdapter();
        rvLoadMore.setLayoutManager(new LinearLayoutManager(this));
        rvLoadMore.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        adapter.refreshData(listData);

        //TODO RecyclerView上拉加载更多
        rvLoadMore.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i < 12; i++) {
            listData.add("数据索引：" + i);
        }
    }
}
