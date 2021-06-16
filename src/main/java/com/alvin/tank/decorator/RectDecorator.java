package com.alvin.tank.decorator;

import com.alvin.tank.GameObject;

import java.awt.*;

public class RectDecorator extends GODecorator{

    public RectDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(super.gameObject.getX(),super.gameObject.getY(),super.gameObject.getWeight(),super.gameObject.getHeight());
        g.setColor(c);
    }

    @Override
    public int getWeight() {
        return super.gameObject.getWeight();
    }

    @Override
    public int getHeight() {
        return super.gameObject.getHeight();
    }
}
