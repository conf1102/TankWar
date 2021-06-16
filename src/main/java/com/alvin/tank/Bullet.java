package com.alvin.tank;

import java.awt.*;

public class Bullet extends GameObject {
    private static final int SPEED = 10;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    private Direction direction;
    private boolean living = true;
    private Group group;
    private Rectangle rectangle = new Rectangle();


    public Bullet(int x, int y, Direction direction, Group group) {
        this.setX(x);
        this.setY(y);
        this.direction = direction;
        this.group = group;

        rectangle.x = getX();
        rectangle.y = getY();
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
        }
        switch (direction) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, getX(), getY(), null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, getX(), getY(), null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, getX(), getY(), null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, getX(), getY(), null);
                break;
        }
        move();

    }

    @Override
    public int getWeight() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    private void move() {
        switch (direction) {
            case LEFT:
                this.setX(this.getX() - SPEED);
                break;
            case UP:
                this.setY(this.getY() - SPEED);
                break;
            case RIGHT:
                this.setX(this.getX() + SPEED);
                break;
            case DOWN:
                this.setY(this.getY() + SPEED);
                break;
        }
        rectangle.x = getX();
        rectangle.y = getY();
        if (getX() < 0 || getY() < 0 || getX() > TankFrame.GAME_WIDTH || getY() > TankFrame.GAME_HEIGHT) {
            living = false;
        }
    }


    public void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
