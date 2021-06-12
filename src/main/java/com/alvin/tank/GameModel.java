package com.alvin.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    Tank myTank = new Tank(200, 500, Direction.DOWN, Group.GOOD, this);
    List<Bullet> bulletList = new ArrayList<>();
    List<Tank> enemyTankList = new ArrayList<>();
    List<Explode> explodeList = new ArrayList<>();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        //Init Enemy Tank List
        for (int i = 0; i < initTankCount; i++) {
            this.enemyTankList.add(new Tank(50 + i * 80, 200, Direction.DOWN, Group.BAD, this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("Bullets Number: " + bulletList.size(), 10, 60);
        g.drawString("Enemy Tank Number: " + enemyTankList.size(), 10, 80);
        g.drawString("Explode Number: " + explodeList.size(), 10, 100);
        g.setColor(c);
        myTank.paint(g);
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }

        for (int i = 0; i < enemyTankList.size(); i++) {
            enemyTankList.get(i).paint(g);
        }

        for (int i = 0; i < explodeList.size(); i++) {
            explodeList.get(i).paint(g);
        }

        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < enemyTankList.size(); j++) {
                bulletList.get(i).collideWith(enemyTankList.get(j));
            }
        }
    }
    public Tank getMyTank() {
        return myTank;
    }

}
