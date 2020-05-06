package com.mulganov.job.lib.mg2d;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mulganov.job.lib.mg2d.scena.Scena;


public class MG2D {
    private mg2dThread thread;
    private mg2dView view;

    private Scena.Size size;

    public MG2D(Context context){
        view = new mg2dView(context);
        thread = view.getThread();
    }

    public View getView(){
        return view;
    }

    public void setScena(Scena scena){
        thread.setScena(scena);
    }

    public Scena getScena() {
        return thread.getScena();
    }

    public Scena.Size getGlobalSize() {
        return size;
    }

    public void setGlobalSize(Scena.Size size) {
        this.size = size;
    }
}
