package com.alvin.tank;

import java.awt.*;

public class Explode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;
    TankFrame frame = null;

    private int setup = 0;

    public Explode(int x, int y, TankFrame frame) {
        this.x = x;
        this.y = y;
        this.frame = frame;

//        new Audio("audio/explode.wav").play();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[setup++], x, y, null);
        if (setup >= ResourceMgr.explodes.length) {
            frame.explodeList.remove(this);
        }
    }
}
