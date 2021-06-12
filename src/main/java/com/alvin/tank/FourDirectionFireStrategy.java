package com.alvin.tank;

public class FourDirectionFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Direction[] directions = Direction.values();
        for (int i = 0; i < Direction.values().length; i++) {
            new Bullet(bX, bY, directions[i], tank.getGroup(), tank.gm);
        }

    }
}
