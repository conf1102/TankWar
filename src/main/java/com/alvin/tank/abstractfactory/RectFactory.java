package com.alvin.tank.abstractfactory;

import com.alvin.tank.Direction;
import com.alvin.tank.Group;
import com.alvin.tank.TankFrame;

public class RectFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new RectExplode(x, y, tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return new RectBullet(x, y, direction, group, tankFrame);
    }


}
