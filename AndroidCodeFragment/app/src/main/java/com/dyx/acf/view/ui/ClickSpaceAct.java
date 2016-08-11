package com.dyx.acf.view.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;

/**
 * Created by dayongxin on 2016/8/11.
 */
public class ClickSpaceAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_click_space_layout);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (ClickSpaceAct.this.getCurrentFocus() != null) {
                if (ClickSpaceAct.this.getCurrentFocus().getWindowToken() != null) {
                    imm.hideSoftInputFromWindow(ClickSpaceAct.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        }
        return super.onTouchEvent(event);
    }
}
