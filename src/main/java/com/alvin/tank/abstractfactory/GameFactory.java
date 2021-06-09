package com.alvin.tank.abstractfactory;

import com.alvin.tank.Direction;
import com.alvin.tank.Group;
import com.alvin.tank.TankFrame;

public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Direction direction, Group group, TankFrame tankFrame);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tankFrame);
    public abstract BaseBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame);

}
