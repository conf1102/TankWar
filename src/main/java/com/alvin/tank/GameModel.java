package com.alvin.tank;

import com.alvin.tank.cor.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    Tank myTank = new Tank(200, 500, Direction.DOWN, Group.GOOD, this);

    private List<GameObject> objectList = new ArrayList<>();
    ColliderChain chain = new ColliderChain();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        //Init Enemy Tank List
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50 + i * 80, 200, Direction.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject gameObject) {
        this.objectList.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        this.objectList.remove(gameObject);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("Bullets Number: " + bulletList.size(), 10, 60);
//        g.drawString("Enemy Tank Number: " + enemyTankList.size(), 10, 80);
//        g.drawString("Explode Number: " + explodeList.size(), 10, 100);
        g.setColor(c);
        myTank.paint(g);
        for (int i = 0; i < objectList.size(); i++) {
            objectList.get(i).paint(g);
        }

        //Collide Logic
        for (int i = 0; i < objectList.size(); i++) {
            for (int j = i + 1; j < objectList.size(); j++) {
                GameObject o1 = objectList.get(i);
                GameObject o2 = objectList.get(j);
                chain.collide(o1,o2);
            }
        }

//        for (int i = 0; i < bulletList.size(); i++) {
//            for (int j = 0; j < enemyTankList.size(); j++) {
//                bulletList.get(i).collideWith(enemyTankList.get(j));
//            }
//        }
    }

    public Tank getMyTank() {
        return myTank;
    }

}
