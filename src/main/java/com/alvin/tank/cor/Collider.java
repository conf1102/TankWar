package com.alvin.tank.cor;

import com.alvin.tank.GameObject;

public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
