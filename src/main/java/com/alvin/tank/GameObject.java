package com.alvin.tank;

import java.awt.*;

public abstract class GameObject {
    private int x;
    private int y;


    public abstract void paint(Graphics g);
    public abstract int getWeight();
    public abstract int getHeight();


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
