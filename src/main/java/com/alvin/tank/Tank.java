package com.alvin.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x;
    private int y;

    private Direction direction = Direction.DOWN;
    private static final int SPEED = 5;
    public static final int WIDTH = ResourceMgr.tankD.getWidth();
    public static final int HEIGHT = ResourceMgr.tankD.getHeight();
    private boolean moving = true;
    private boolean living = true;
    private Group group = Group.BAD;
    private Random random = new Random();
    private TankFrame tf = null;

    public Tank(int x, int y, Direction direction, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!living) {
            this.tf.enemyTankList.remove(this);
            return;
        }

        switch (direction) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
        }

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
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDirection();
        }

    }

    private void randomDirection() {
        this.direction = Direction.values()[random.nextInt(4)];
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bulletList.add(new Bullet(bX, bY, this.direction, this.group, this.tf));
    }

    public void die() {
        this.living = false;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
