package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dyx.acf.R;
import com.dyx.acf.view.adapter.MainAdapter;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.rv.library.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dayongxin on 2016/8/10.
 */
public class FloatingbuttonAct extends BaseActivity {
    @Bind(R.id.rv_float_button)
    RecyclerView rvFloatButton;
    @Bind(R.id.fb_but)
    com.dyx.acf.customlibrary.widget.Floatingbutton fbBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_floating_button_layout);
        ButterKnife.bind(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        MainAdapter adapter = new MainAdapter();
        rvFloatButton.setLayoutManager(new LinearLayoutManager(this));
        rvFloatButton.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        rvFloatButton.setAdapter(adapter);
        adapter.refreshData(getData());
        //监听RecyclerView滑动事件
        rvFloatButton.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!recyclerView.canScrollVertically(-1)) {
                    onScrolledToTop();
                } else if (!recyclerView.canScrollVertically(1)) {
                    onScrolledToBottom();
                } else if (dy > 0) {
                    onScrolledToDown(dy);
                } else if (dy < 0) {
                    onScrolledToUp(dy);
                }
            }
        });
    }

    private void onScrolledToUp(int dy) {
        fbBut.hide();
    }

    private void onScrolledToDown(int dy) {
        fbBut.show();
    }

    private void onScrolledToBottom() {

    }

    private void onScrolledToTop() {

    }

    private List<String> getData() {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            results.add("第" + i + "条测试数据！");
        }
        return results;
    }

    @OnClick(R.id.fb_but)
    public void onClick() {
        showSnackbar(fbBut, getString(R.string.click_me));
        rvFloatButton.smoothScrollToPosition(0);
    }
}
