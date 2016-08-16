package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.memory.MemoryManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dayongxin on 2016/8/16.
 */
public class MemoryAct extends BaseActivity {
    @Bind(R.id.btn_print)
    Button btnPrint;
    @Bind(R.id.tv_show_result)
    TextView tvShowResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_memory_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_print)
    public void onClick() {
        tvShowResult.setText("应用程序最大内存：" + MemoryManager.getMaxMemory() + "\n"
                + "应用程序获取到的内存：" + MemoryManager.getTotalMemory() + "\n"
                + "应用程序获取内存中闲置内存：" + MemoryManager.getFreeMemory() + "\n"
                + "判断应用是否在低内存条件下运行：" + MemoryManager.isRunLowMemory() + "\n"
                + "获取手机内部可用空间大小：" + MemoryManager.getTotalInternalMemorySize() + "\n"
                + "获取手机外部可用空间大小：" + MemoryManager.getAvailableExternalMemorySize() + "\n"
                + "获取手机外部空间大小：" + MemoryManager.getTotalExternalMemorySize() + "\n"
                + "外部存储是否可用：" + MemoryManager.externalMemoryAvailable());
    }
}
