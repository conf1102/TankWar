package com.alvin.tank;

import java.awt.*;

public class Tank {
    private int x;
    private int y;

    private Direction direction = Direction.DOWN;
    private static final int SPEED = 10;
    private boolean moving = false;

    public Tank(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);

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
