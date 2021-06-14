package com.alvin.tank;

import java.awt.*;

public class Wall extends GameObject {

    int weight;
    int height;

    private Rectangle rectangle;

    public Wall(int x, int y, int weight, int height) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
        this.rectangle = new Rectangle(x, y, weight, height);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GRAY);
        g.fillRect(x, y, weight, height);
        g.setColor(c);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
