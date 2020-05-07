package com.mulganov.job.lib.mg2d.setting;

import android.graphics.Color;

import com.mulganov.job.lib.mg2d.scena.Scena;

public class Setting {

    private Scena.Size size;
    private Border border = new Border();
    private int background = Color.BLACK;

    public Scena.Size getSize() {
        return size;
    }

    public void setSize(Scena.Size size) {
        this.size = size;
    }

    public Border getBorder() {
        return border;
    }

    public void setBorder(Border border) {
        this.border = border;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }
}
