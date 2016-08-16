package com.dyx.acf.view.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dayongxin on 2016/8/16.
 */
public class AddCartAnimAct extends BaseActivity {
    @Bind(R.id.iv_cart_icon)
    ImageView ivCartIcon;
    @Bind(R.id.tv_cart_btn)
    TextView tvCartBtn;
    @Bind(R.id.tv_new)
    TextView tvNew;
    private Animation mAnimation;
    private PopupWindow mPopupWindow;
    private int goodsNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_add_cart_anim_layout);
        ButterKnife.bind(this);
        initAnim();
    }

    private void initAnim() {
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.cart_anim);
        mAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                goodsNum++;
                tvNew.setText(goodsNum + "");
                ivCartIcon.setVisibility(View.INVISIBLE);
                createPopbWindow();
                mPopupWindow.showAtLocation(ivCartIcon, Gravity.CENTER
                        | Gravity.CENTER_HORIZONTAL, 0, 0);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                ivCartIcon.setVisibility(View.VISIBLE);
                ivCartIcon.startAnimation(mAnimation);

            }
        }, 1500);
    }

    private void createPopbWindow() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentview = inflater.inflate(R.layout.cart_popup_layout, null);
        contentview.setFocusable(true);
        contentview.setFocusableInTouchMode(true);
        mPopupWindow = new PopupWindow(this);
        mPopupWindow.setContentView(contentview);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        mPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(false);
        mPopupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
    }

    @OnClick(R.id.tv_cart_btn)
    public void onClick() {
        ivCartIcon.setVisibility(View.VISIBLE);
        ivCartIcon.startAnimation(mAnimation);
    }
}
