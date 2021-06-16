package com.alvin.tank.strategy;

import com.alvin.tank.Bullet;
import com.alvin.tank.GameModel;
import com.alvin.tank.Tank;
import com.alvin.tank.decorator.RectDecorator;

public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        GameModel.getInstance().add(new RectDecorator(new Bullet(bX, bY, tank.getDirection(), tank.getGroup())));
    }
}
