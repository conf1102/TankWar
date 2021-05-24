package com.alvin.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 10;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;
    private int x, y;
    private Direction direction;
    private boolean live = true;
    private TankFrame tf;


    public Bullet(int x, int y, Direction direction, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bulletList.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);
        move();

    }

    private void move() {
        switch (direction) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }
}
