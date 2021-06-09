package com.alvin.tank.abstractfactory;

import com.alvin.tank.ResourceMgr;
import com.alvin.tank.TankFrame;

import java.awt.*;

public class RectExplode extends BaseExplode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;
    TankFrame frame = null;

    private int setup = 0;

    public RectExplode(int x, int y, TankFrame frame) {
        this.x = x;
        this.y = y;
        this.frame = frame;
    }

    @Override
    public void paint(Graphics g) {
//        g.drawImage(ResourceMgr.explodes[setup++], x, y, null);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10 * setup, 10 * setup);
        setup ++;
        if (setup >= 15) {
            frame.explodeList.remove(this);
        }
    }
}
