package com.mulganov.job.lib.mg2d.graph;

import android.graphics.Canvas;

public class Graph {
    private String key;
    private int index;
    private Draw draw;
    private Click click;

    public String getKey() {
        return key;
    }

    public void draw(Canvas canvas){
        draw.draw(canvas);
    }
    public void click(Click.Event event){
        click.onClick(event);
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Draw getDraw() {
        return draw;
    }

    public void setDraw(Draw draw) {
        this.draw = draw;
    }

    public Click getClick() {
        return click;
    }

    public void setClick(Click click) {
        this.click = click;
    }

    public interface Click {
        void onClick(Event event);
        public static class Event{
            public int x, y;
        }
    }

    public interface Draw {
        void draw(Canvas canvas);
    }

}
