package com.alvin.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("Tank War");
        TankFrame frame = new TankFrame();
        while (true){
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
