package com.alvin.tank.abstractfactory;

import com.alvin.tank.*;

public class DefaultFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return new Tank(x, y, direction, group, tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x, y, tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return new Bullet(x, y, direction, group, tankFrame);
    }


}
