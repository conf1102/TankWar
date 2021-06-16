package com.alvin.tank.decorator;

import com.alvin.tank.GameObject;

import java.awt.*;

public abstract class GODecorator extends GameObject {
    GameObject gameObject;

    public GODecorator(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public void paint(Graphics g) {

    }
}
