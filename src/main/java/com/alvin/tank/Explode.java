package com.alvin.tank;

import java.awt.*;

public class Explode extends GameObject {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;
    GameModel gm = null;

    private int setup = 0;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;

//        new Audio("audio/explode.wav").play();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[setup++], x, y, null);
        if (setup >= ResourceMgr.explodes.length) {
            gm.remove(this);
        }
    }
}
