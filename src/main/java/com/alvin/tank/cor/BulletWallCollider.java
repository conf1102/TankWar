package com.alvin.tank.cor;

import com.alvin.tank.Bullet;
import com.alvin.tank.GameObject;
import com.alvin.tank.Wall;

public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            if (bullet.getRectangle().intersects(wall.getRectangle())) {
                bullet.die();
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            this.collide(o2, o1);
        }
        return true;
    }
}
