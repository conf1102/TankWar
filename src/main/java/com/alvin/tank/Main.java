package com.alvin.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFrame frame = new TankFrame();
        //Init Enemy Tank List
        for (int i = 0; i < 5; i++) {
            frame.enemyTankList.add(new Tank(50 + i * 80, 200, Direction.DOWN,Group.BAD, frame));
        }
        while (true) {
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
