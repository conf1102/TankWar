package com.alvin.tank;

import java.awt.*;

public class Explode extends GameObject {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;

    private int setup = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        GameModel.getInstance().add(this);
//        new Audio("audio/explode.wav").play();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[setup++], x, y, null);
        if (setup >= ResourceMgr.explodes.length) {
            GameModel.getInstance().remove(this);
        }
    }

    @Override
    public int getWeight() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
}
