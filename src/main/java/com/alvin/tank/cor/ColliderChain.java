package com.alvin.tank.cor;

import com.alvin.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider {
    private List<Collider> colliderList = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }

    public void add(Collider collider) {
        colliderList.add(collider);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliderList.size(); i++) {
            if (!colliderList.get(i).collide(o1, o2)) {
                return false;
            }
        }
        return true;
    }
}
