package com.alvin.tank;

import java.awt.*;

public class Tank {
    private int x;
    private int y;

    private Direction direction = Direction.DOWN;
    private static final int SPEED = 5;
    private boolean moving = false;
    private TankFrame tf = null;

    public Tank(int x, int y, Direction direction, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
        move();

    }

    private void move() {
        if (!moving) {
            return;
        }
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
    }

    public void fire() {
        tf.bullet = new Bullet(this.x, this.y, this.direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }


}
