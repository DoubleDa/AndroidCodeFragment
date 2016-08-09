package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dyx.acf.R;
import com.dyx.acf.view.adapter.MainAdapter;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.rv.library.listener.OnItemClickListener;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.rv_main)
    RecyclerView rvMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        MainAdapter adapter = new MainAdapter();
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(adapter);

        adapter.setmOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(String itemValue, int viewId, int position) {
                switch (position) {
                    case 0:
                        intentTo(CommonCodeFragmentAct.class);
                        break;
                }
            }
        });

        adapter.refreshData(getData());
    }

    private List<String> getData() {
        return Arrays.asList(getResources().getStringArray(R.array.main_menu));
    }
}
