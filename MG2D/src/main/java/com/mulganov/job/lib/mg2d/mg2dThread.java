package com.mulganov.job.lib.mg2d;


import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import com.mulganov.job.lib.mg2d.scena.Scena;

import java.util.ArrayList;

public class mg2dThread extends java.lang.Thread {

    private boolean runFlag = true;
    private SurfaceHolder surfaceHolder;

    private Scena scena;
    private boolean newScena;

    public mg2dThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;

    }


    public void setRunning(boolean run) {
        runFlag = run;
    }

    @Override
    public void run() {
        Canvas canvas;
        while (runFlag) {

            canvas = null;
            try {

                // получаем объект Canvas и выполняем отрисовку
                canvas = surfaceHolder.lockCanvas();
                if (canvas == null) return;
                synchronized (surfaceHolder) {
                    canvas.drawColor(Color.BLACK);

                    if (scena == null) continue;

                    for (int i = 0; true; i++){
                        if (newScena){
                            newScena = false;
                            break;
                        }
                        if (scena.get(i) != null)
                            scena.get(i).draw(canvas);
                        else
                            break;
                    }
                }


            } finally {
                if (canvas != null) {
                    // отрисовка выполнена. выводим результат на экран
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

        }
    }

    public Scena getScena() {
        return scena;
    }

    public void setScena(Scena scena) {
        this.scena = scena;
        newScena = true;
    }

    public boolean isNewScena(){
        return newScena;
    }

    public void setNewScena(boolean b) {
        this.newScena = b;
    }
}


