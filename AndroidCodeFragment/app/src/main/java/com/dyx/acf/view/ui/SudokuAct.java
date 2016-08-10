package com.dyx.acf.view.ui;

import android.os.Bundle;

import com.dyx.acf.R;
import com.dyx.acf.customlibrary.view.SudokuView;
import com.dyx.acf.view.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dayongxin on 2016/8/10.
 */
public class SudokuAct extends BaseActivity {
    @Bind(R.id.sv_my)
    SudokuView svMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_sudoku_layout);
        ButterKnife.bind(this);
    }
}
