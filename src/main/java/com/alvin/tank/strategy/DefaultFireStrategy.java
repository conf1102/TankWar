package com.alvin.tank.strategy;

import com.alvin.tank.Bullet;
import com.alvin.tank.Tank;

public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        new Bullet(bX, bY, tank.getDirection(), tank.getGroup(), tank.gm);
    }
}
