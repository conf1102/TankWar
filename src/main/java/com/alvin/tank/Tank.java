package com.alvin.tank;

import com.alvin.tank.strategy.DefaultFireStrategy;
import com.alvin.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {
    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight();
    private static final int SPEED = 5;
    FireStrategy fireStrategy;
    private Rectangle rectangle = new Rectangle();
    private int prevX, prevY;
    private Direction direction = Direction.DOWN;
    private boolean moving = true;
    private boolean living = true;
    private Group group = Group.BAD;
    private Random random = new Random();

    public Tank(int x, int y, Direction direction, Group group) {
        this.setX(x);
        this.setY(y);
        this.direction = direction;
        this.group = group;

        rectangle.x = this.getX();
        rectangle.y = this.getY();
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
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
        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
            return;
        }

        switch (direction) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, this.getX(), this.getY(), null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, this.getX(), this.getY(), null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, this.getX(), this.getY(), null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, this.getX(), this.getY(), null);
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

    public void back() {
        this.setX(prevX);
        this.setY(prevY);
    }

    private void move() {
        prevX = this.getX();
        prevY = this.getY();
        if (!moving) {
            return;
        }
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
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomDirection();
        }
        boundsCheck();
        rectangle.x = this.getX();
        rectangle.y = this.getY();

    }

    private void boundsCheck() {
        if (this.getX() < 2) {
            this.setX(2);
        }
        if (this.getY() < 28) {
            this.setY(28);
        }
        if (this.getX() > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) {
            this.setX(TankFrame.GAME_WIDTH - Tank.WIDTH - 2);
        }
        if (this.getY() > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {
            this.setY(TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2);
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


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getPrevX() {
        return prevX;
    }

    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

}
