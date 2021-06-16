package com.alvin.tank;

import java.awt.*;

public class Wall extends GameObject {

    int weight;
    int height;

    private Rectangle rectangle;

    public Wall(int x, int y, int weight, int height) {
        this.setX(x);
        this.setY(y);
        this.weight = weight;
        this.height = height;
        this.rectangle = new Rectangle(x, y, weight, height);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GRAY);
        g.fillRect(this.getX(), this.getY(), weight, height);
        g.setColor(c);
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
