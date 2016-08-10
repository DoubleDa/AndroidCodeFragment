package com.dyx.acf.customlibrary.bean;

/**
 * Created by dayongxin on 2016/8/10.
 */
public class Cell {
    private float centerX;
    private float centerY;
    private boolean selected;

    public Cell(float centerX, float centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public float getCenterX() {
        return centerX;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
