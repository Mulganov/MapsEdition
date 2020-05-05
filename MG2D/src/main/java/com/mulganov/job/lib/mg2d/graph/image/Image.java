package com.mulganov.job.lib.mg2d.graph.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.mulganov.job.lib.mg2d.graph.Graph;

public class Image extends Graph {

    private Bitmap bitmap;
    private mg2dMatrix matrix;

    private Paint p;

    public Image(final Bitmap bitmap, mg2dMatrix matrix){
        setW(matrix.getW());
        setH(matrix.getH());
        setX(matrix.getTx());
        setY(matrix.getTy());
        this.bitmap = bitmap;
        this.matrix = matrix;
        super.setDraw(new Draw() {
            @Override
            public void draw(Canvas canvas) {
                if (p == null){
                    p = new Paint();
                    p.setAlpha(getAlpha());
                }

                canvas.drawBitmap(getBitmap(), getMatrix().create(bitmap), p);
            }
        });
    }

    @Override
    public boolean isClickRecTemplate(Click.Event event){
        int xx = event.x;
        int yy = event.y;

        int x = getX();
        int y = getY();

        System.out.println("----------------------");
        System.out.println(xx + "X" + yy);
        System.out.println(x + "X" + y);
        System.out.println(matrix.getW() + "X" + matrix.getH());

        if (x <= xx && xx <= x + matrix.getW()){
            if (y <= yy && yy <= y + matrix.getH()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void setAlpha(int alpha){
        super.setAlpha(alpha);
        p.setAlpha(alpha);
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public mg2dMatrix getMatrix() {
        return matrix;
    }

    public void setMatrix(mg2dMatrix matrix) {
        this.matrix = matrix;
    }

}
