package com.alvin.tank;

import com.alvin.tank.strategy.DefaultFireStrategy;
import com.alvin.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {
    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight();
    private static final int SPEED = 5;
    public GameModel gm = null;
    FireStrategy fireStrategy;
    Rectangle rect = new Rectangle();
    private int x;
    private int y;
    private Direction direction = Direction.DOWN;
    private boolean moving = true;
    private boolean living = true;
    private Group group = Group.BAD;
    private Random random = new Random();

    public Tank(int x, int y, Direction direction, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group = group;
        this.gm = gm;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        if (this.group == Group.GOOD) {
            String goodTankFS = (String) PropertyMgr.get("goodTankFS");
            try {
                fireStrategy = (FireStrategy) Class.forName(goodTankFS).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String badTankFS = (String) PropertyMgr.get("badTankFS");
            try {
                fireStrategy = (FireStrategy) Class.forName(badTankFS).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            fireStrategy = new DefaultFireStrategy();
        }
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            this.gm.remove(this);
            return;
        }

        switch (direction) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
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
        boundsCheck();
        rect.x = this.x;
        rect.y = this.y;

    }

    private void boundsCheck() {
        if (this.x < 2) {
            x = 2;
        }
        if (this.y < 28) {
            y = 28;
        }
        if (x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        }
        if (y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
        }
    }

    private void randomDirection() {
        this.direction = Direction.values()[random.nextInt(4)];
    }

    public void fire() {
/*        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bulletList.add(new Bullet(bX, bY, this.direction, this.group, this.tf));*/
        this.fireStrategy.fire(this);
    }

    public void die() {
        this.living = false;
    }

    public void stop() {
        this.moving = false;
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

    public Rectangle getRect() {
        return rect;
    }

}
