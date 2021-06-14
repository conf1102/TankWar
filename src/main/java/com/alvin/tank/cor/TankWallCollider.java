package com.alvin.tank.cor;

import com.alvin.tank.GameObject;
import com.alvin.tank.Tank;
import com.alvin.tank.Wall;

public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            if (tank.getRectangle().intersects(wall.getRectangle())) {
                tank.back();
            }
        } else if (o1 instanceof Wall && o2 instanceof Tank) {
            this.collide(o2, o1);
        }
        return true;
    }
}
