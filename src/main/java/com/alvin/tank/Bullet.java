package com.alvin.tank;

import java.awt.*;

public class Bullet extends GameObject {
    private static final int SPEED = 10;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    private int x, y;
    private Direction direction;
    private boolean living = true;
    private Group group;
    private GameModel gm;

    Rectangle rect = new Rectangle();


    public Bullet(int x, int y, Direction direction, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group = group;
        this.gm = gm;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        gm.add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            gm.remove(this);
        }
        switch (direction) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
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
        rect.x = this.x;
        rect.y = this.y;
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            living = false;
        }
    }

    public boolean collideWith(Tank tank) {
        if (this.group == tank.getGroup()) {
            return false;
        }
        if (rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            gm.add(new Explode(eX, eY, gm));
            return true;
        }
        return false;
    }

    private void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
